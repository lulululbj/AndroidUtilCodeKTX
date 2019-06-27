package luyao.util.ktx.ext

import java.security.MessageDigest

/**
 * Created by luyao
 * on 2019/6/14 15:28
 */
fun ByteArray.md5Bytes(): ByteArray = hash(this, Hash.MD5)
fun ByteArray.md5(): String = hash(this, Hash.MD5).toHexString()
fun ByteArray.sha1Bytes(): ByteArray = hash(this, Hash.SHA1)
fun ByteArray.sha1(): String = hash(this, Hash.SHA1).toHexString()
fun ByteArray.sha256Bytes(): ByteArray = hash(this, Hash.SHA256)
fun ByteArray.sha256(): String = hash(this, Hash.SHA256).toHexString()


enum class Hash(algorithm: String) {
    MD5("md5"),
    SHA1("sha1"),
    SHA256("sha256")
}

fun hash(data: ByteArray, algorithm: Hash): ByteArray {
    val messageDigest = MessageDigest.getInstance(algorithm.name)
    return messageDigest.digest(data)
}
