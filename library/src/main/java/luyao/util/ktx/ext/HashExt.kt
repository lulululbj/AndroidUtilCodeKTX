package luyao.util.ktx.ext

import java.security.MessageDigest

/**
 * Created by luyao
 * on 2019/6/14 15:28
 */
@kotlin.internal.LowPriorityInOverloadResolution
fun ByteArray.md5(): ByteArray = hash(this, Hash.MD5)
fun ByteArray.md5() : String = hash(this,Hash.MD5).toHexString()
fun ByteArray.sha1(): ByteArray = hash(this, Hash.SHA1)
fun ByteArray.sha256(): ByteArray = hash(this, Hash.SHA256)




enum class Hash(algorithm: String) {
    MD5("md5"),
    SHA1("sha1"),
    SHA256("sha256")
}

fun hash(data: ByteArray, algorithm: Hash): ByteArray {
    val messageDigest = MessageDigest.getInstance(algorithm.name)
    return messageDigest.digest(data)
}
