package luyao.util.ktx.ext

import luyao.util.ktx.func.*
import luyao.util.ktx.util.MimeType
import java.io.File
import java.nio.charset.Charset

/**
 * Created by luyao
 * on 2019/7/18 9:25
 */

val File.canListFiles: Boolean
    get() = canRead() and isDirectory

val File.totalSize: Long
    get() = if (isFile) length() else getFolderSize(this)

val File.formatSize: String
    get() = getFormatFileSize(totalSize)

val File.mimeType: String
    get() = MimeType.getMimeType(extension, isDirectory)

fun File.listFiles(isRecursive: Boolean = false, filter: ((file: File) -> Boolean)? = null): Array<out File> {
    val fileList = if (!isRecursive) listFiles() else getAllSubFile(this)
    var result: Array<File> = arrayOf()
    return if (filter == null) fileList
    else {
        for (file in fileList) {
            if (filter(file)) result = result.plus(file)
        }
        result
    }
}

fun File.writeText(append: Boolean = false, text: String, charset: Charset = Charsets.UTF_8) {
    if (append) appendText(text, charset) else writeText(text, charset)
}

fun File.writeBytes(append: Boolean = false, bytes: ByteArray) {
    if (append) appendBytes(bytes) else writeBytes(bytes)
}

/**
 *   [destFile] dest file/folder
 *   [overwrite] whether to override dest file/folder if exist
 *   [reserve] Whether to reserve source file/folder
 */
fun File.moveTo(destFile: File, overwrite: Boolean = true, reserve: Boolean = true): Boolean {
    val dest = copyRecursively(destFile, overwrite)
    if (!reserve) deleteRecursively()
    return dest
}

/**
 *   [destFolder] dest folder
 *   [overwrite] whether to override dest file/folder if exist
 *   [func] progress callback (from 0 to 100)
 */
fun File.moveToWithProgress(
    destFolder: File,
    overwrite: Boolean = true,
    reserve: Boolean = true,
    func: ((file: File, i: Int) -> Unit)? = null
) {

    if (isDirectory) copyFolder(this, File(destFolder, name), overwrite, func)
    else copyFile(this, File(destFolder, name), overwrite, func)

    if (!reserve) deleteRecursively()
}

fun File.rename(newName: String) =
    rename(File("$parent${File.separator}$newName"))

fun File.rename(newFile: File) =
    if (newFile.exists()) false else renameTo(newFile)

// 获取内部存储容量，可用，已用空间
// getCharset
// 文件名冲突
