package luyao.util.ktx.util

import android.webkit.MimeTypeMap
import java.util.*
import java.util.regex.Pattern

class MimeType {

    companion object {
        private const val ALL_MIME_TYPES = "*/*"
        private val MIME_TYPES = HashMap<String, String>(1 + (66 / 0.75).toInt())

        fun getMimeType(extension: String, isDirectory: Boolean): String {
            if (isDirectory) {
                return ""
            }

            var type: String? = ALL_MIME_TYPES

            // mapping extension to system mime types
            if (extension.isNotEmpty()) {
                val extensionLowerCase = extension.toLowerCase(Locale
                        .getDefault())
                val mime = MimeTypeMap.getSingleton()
                type = mime.getMimeTypeFromExtension(extensionLowerCase)
                if (type == null) {
                    type = MIME_TYPES[extensionLowerCase]
                }
            }
            if (type == null) type = ALL_MIME_TYPES
            return type
        }

        fun mimeTypeMatch(mime: String, input: String): Boolean {
            return Pattern.matches(mime.replace("*", ".*"), input)
        }


        /**
         * Helper method for [.getMimeType]
         * to calculate the last '.' extension of files
         * @param path the path of file
         * @return extension extracted from name in lowercase
         */
        fun getExtension(path: String): String {
            return if (path.contains("."))
                path.substring(path.lastIndexOf(".") + 1).toLowerCase()
            else
                ""
        }
    }
    init {
        /*
         * ================= MIME TYPES ====================
		 */
        MIME_TYPES["asm"] = "text/x-asm"
        MIME_TYPES["json"] = "application/json"
        MIME_TYPES["js"] = "application/javascript"

        MIME_TYPES["def"] = "text/plain"
        MIME_TYPES["in"] = "text/plain"
        MIME_TYPES["rc"] = "text/plain"
        MIME_TYPES["list"] = "text/plain"
        MIME_TYPES["log"] = "text/plain"
        MIME_TYPES["pl"] = "text/plain"
        MIME_TYPES["prop"] = "text/plain"
        MIME_TYPES["properties"] = "text/plain"
        MIME_TYPES["rc"] = "text/plain"
        MIME_TYPES["ini"] = "text/plain"
        MIME_TYPES["md"] = "text/markdown"

        MIME_TYPES["epub"] = "application/epub+zip"
        MIME_TYPES["ibooks"] = "application/x-ibooks+zip"

        MIME_TYPES["ifb"] = "text/calendar"
        MIME_TYPES["eml"] = "message/rfc822"
        MIME_TYPES["msg"] = "application/vnd.ms-outlook"

        MIME_TYPES["ace"] = "application/x-ace-compressed"
        MIME_TYPES["bz"] = "application/x-bzip"
        MIME_TYPES["bz2"] = "application/x-bzip2"
        MIME_TYPES["cab"] = "application/vnd.ms-cab-compressed"
        MIME_TYPES["gz"] = "application/x-gzip"
        MIME_TYPES["lrf"] = "application/octet-stream"
        MIME_TYPES["jar"] = "application/java-archive"
        MIME_TYPES["xz"] = "application/x-xz"
        MIME_TYPES["Z"] = "application/x-compress"

        MIME_TYPES["bat"] = "application/x-msdownload"
        MIME_TYPES["ksh"] = "text/plain"
        MIME_TYPES["sh"] = "application/x-sh"

        MIME_TYPES["db"] = "application/octet-stream"
        MIME_TYPES["db3"] = "application/octet-stream"

        MIME_TYPES["otf"] = "application/x-font-otf"
        MIME_TYPES["ttf"] = "application/x-font-ttf"
        MIME_TYPES["psf"] = "application/x-font-linux-psf"

        MIME_TYPES["cgm"] = "image/cgm"
        MIME_TYPES["btif"] = "image/prs.btif"
        MIME_TYPES["dwg"] = "image/vnd.dwg"
        MIME_TYPES["dxf"] = "image/vnd.dxf"
        MIME_TYPES["fbs"] = "image/vnd.fastbidsheet"
        MIME_TYPES["fpx"] = "image/vnd.fpx"
        MIME_TYPES["fst"] = "image/vnd.fst"
        MIME_TYPES["mdi"] = "image/vnd.ms-mdi"
        MIME_TYPES["npx"] = "image/vnd.net-fpx"
        MIME_TYPES["xif"] = "image/vnd.xiff"
        MIME_TYPES["pct"] = "image/x-pict"
        MIME_TYPES["pic"] = "image/x-pict"

        MIME_TYPES["adp"] = "audio/adpcm"
        MIME_TYPES["au"] = "audio/basic"
        MIME_TYPES["snd"] = "audio/basic"
        MIME_TYPES["m2a"] = "audio/mpeg"
        MIME_TYPES["m3a"] = "audio/mpeg"
        MIME_TYPES["oga"] = "audio/ogg"
        MIME_TYPES["spx"] = "audio/ogg"
        MIME_TYPES["aac"] = "audio/x-aac"
        MIME_TYPES["mka"] = "audio/x-matroska"

        MIME_TYPES["jpgv"] = "video/jpeg"
        MIME_TYPES["jpgm"] = "video/jpm"
        MIME_TYPES["jpm"] = "video/jpm"
        MIME_TYPES["mj2"] = "video/mj2"
        MIME_TYPES["mjp2"] = "video/mj2"
        MIME_TYPES["mpa"] = "video/mpeg"
        MIME_TYPES["ogv"] = "video/ogg"
        MIME_TYPES["flv"] = "video/x-flv"
        MIME_TYPES["mkv"] = "video/x-matroska"
    }


}