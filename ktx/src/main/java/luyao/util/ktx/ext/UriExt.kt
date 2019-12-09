package luyao.util.ktx.ext

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.text.TextUtils
import luyao.util.ktx.Ktx
import java.io.File
import java.lang.reflect.Array

/*
 * from Blankj
 * https://github.com/Blankj/AndroidUtilCode/blob/master/lib/utilcode/src/main/java/com/blankj/utilcode/util/UriUtils.java
 */

/**
 * Created by luyao
 * on 2019/12/9 15:20
 */
fun Uri.toRealFile(): File? {
    val authority = authority
    val scheme = scheme
    val path = path

    if (fromN() && path != null && path.startsWith("/external/")) {
        val file = File(Environment.getExternalStorageDirectory().absolutePath + path.replace("/external", ""))
        if (file.exists()) {
            return file
        }
    }

    if (ContentResolver.SCHEME_FILE == scheme) {
        return if (path != null) File(path) else null
    } else if (fromKitKat() && DocumentsContract.isDocumentUri(Ktx.app, this))  {
        if ("com.android.externalstorage.documents" == authority) {
            val docId = DocumentsContract.getDocumentId(this)
            val split = docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val type = split[0]
            if ("primary".equals(type, ignoreCase = true)) {
                return File(Environment.getExternalStorageDirectory().toString() + "/" + split[1])
            } else {
                // Below logic is how External Storage provider build URI for documents
                // http://stackoverflow.com/questions/28605278/android-5-sd-card-label
                val mStorageManager = Ktx.app.storageManager
                try {
                    val storageVolumeClazz = Class.forName("android.os.storage.StorageVolume")
                    val getVolumeList = mStorageManager?.javaClass?.getMethod("getVolumeList")
                    val getUuid = storageVolumeClazz.getMethod("getUuid")
                    val getState = storageVolumeClazz.getMethod("getState")
                    val getPath = storageVolumeClazz.getMethod("getPath")
                    val isPrimary = storageVolumeClazz.getMethod("isPrimary")
                    val isEmulated = storageVolumeClazz.getMethod("isEmulated")

                    val result = getVolumeList?.invoke(mStorageManager)

                    val length = Array.getLength(result)
                    for (i in 0 until length) {
                        val storageVolumeElement = Array.get(result, i)
                        //String uuid = (String) getUuid.invoke(storageVolumeElement);

                        val mounted =
                            Environment.MEDIA_MOUNTED == getState.invoke(storageVolumeElement) || Environment.MEDIA_MOUNTED_READ_ONLY == getState.invoke(
                                storageVolumeElement
                            )

                        //if the media is not mounted, we need not get the volume details
                        if (!mounted) continue

                        //Primary storage is already handled.
                        if (isPrimary.invoke(storageVolumeElement) as Boolean &&
                            isEmulated.invoke(storageVolumeElement) as Boolean) {
                            continue
                        }

                        val uuid = getUuid.invoke(storageVolumeElement) as String

                        if (uuid == type) {
                            return File(getPath.invoke(storageVolumeElement).toString() + "/" + split[1])
                        }
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
            return null
        } else if ("com.android.providers.downloads.documents" == authority) {
            val id = DocumentsContract.getDocumentId(this)
            if (!TextUtils.isEmpty(id)) {
                try {
                    val contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"),
                        java.lang.Long.valueOf(id)
                    )
                    return Ktx.app.getFileFromUri(contentUri, "1_1")
                } catch (e: NumberFormatException) {
                    if (id.startsWith("raw:")) {
                        return File(id.substring(4))
                    }
                }
            }
            return null
        } else if ("com.android.providers.media.documents" == authority) {
            val docId = DocumentsContract.getDocumentId(this)
            val split = docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val type = split[0]
            val contentUri: Uri
            contentUri = when (type) {
                "image" -> MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                "video" -> MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                "audio" -> MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                else -> {
                    return null
                }
            }
            val selection = "_id=?"
            val selectionArgs = arrayOf(split[1])
            return Ktx.app.getFileFromUri(contentUri, selection, selectionArgs)
        } else if (ContentResolver.SCHEME_CONTENT == scheme) {
            return Ktx.app.getFileFromUri(this)
        } else {
            return null
        }
    } else if (ContentResolver.SCHEME_CONTENT == scheme) run {
        return Ktx.app.getFileFromUri(this)
    } else return null

}


private fun Context.getFileFromUri(
    uri: Uri,
    selection: String? = null,
    selectionArgs: kotlin.Array<String>? = null
): File? {
    val cursor = contentResolver.query(
        uri, arrayOf("_data"), selection, selectionArgs, null
    )
    if (cursor == null) {
        return null
    }
    try {
        return if (cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex("_data")
            if (columnIndex > -1) {
                File(cursor.getString(columnIndex))
            } else {
                null
            }
        } else {
            null
        }
    } catch (e: Exception) {
        return null
    } finally {
        cursor.close()
    }
}