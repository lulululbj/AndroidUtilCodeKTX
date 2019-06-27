package luyao.util.ktx.ext

import kotlin.experimental.and

/**
 * Created by luyao
 * on 2019/6/14 15:43
 */

fun ByteArray.toHexString(): String {
    val builder = StringBuilder()
    for (b in this) {
        var hex = Integer.toHexString((b and 0xFF.toByte()).toInt())
        if (hex.length == 1) hex = "0$hex"
        builder.append(hex.toUpperCase())
    }
    return builder.toString()

}