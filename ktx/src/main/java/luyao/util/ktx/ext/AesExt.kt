package luyao.util.ktx.ext

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.security.Key
import javax.crypto.Cipher
import javax.crypto.CipherInputStream
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * Created by luyao
 * on 2019/7/1 16:09
 */

private const val KEY_ALGORITHM = "AES"
private const val CIPHER_ALGORITHM_DEFAULT = "AES"
private const val AES_CFB_NOPADDING = "AES/CFB/NoPadding"

fun ByteArray.aesEncrypt(
    key: ByteArray,
    iv: ByteArray,
    cipherAlgotirhm: String = AES_CFB_NOPADDING
): ByteArray {
    val cipher = initCipher(Cipher.ENCRYPT_MODE, key, iv, cipherAlgotirhm)
    return cipher.doFinal(this)
}

fun ByteArray.aesDecrypt(
    key: ByteArray,
    iv: ByteArray,
    cipherAlgotirhm: String = AES_CFB_NOPADDING
): ByteArray {
    val cipher = initCipher(Cipher.DECRYPT_MODE, key, iv, cipherAlgotirhm)
    return cipher.doFinal(this)
}

fun File.aesEncrypt(
    key: ByteArray,
    iv: ByteArray,
    destFilePath: String,
    cipherAlgotirhm: String = AES_CFB_NOPADDING
): File? {
    return handleFile(Cipher.ENCRYPT_MODE, key, iv, cipherAlgotirhm, path, destFilePath)
}

fun File.aesDecrypt(
    key: ByteArray,
    iv: ByteArray,
    destFilePath: String,
    cipherAlgotirhm: String = AES_CFB_NOPADDING
): File? {
    return handleFile(Cipher.DECRYPT_MODE, key, iv, cipherAlgotirhm, path, destFilePath)
}

fun initAESKey(size: Int): ByteArray {
    val kg = KeyGenerator.getInstance(KEY_ALGORITHM)
    kg.init(size)
    return kg.generateKey().encoded
}

private fun toKey(key: ByteArray): Key = SecretKeySpec(key, KEY_ALGORITHM)

fun initCipher(mode: Int, key: ByteArray, iv: ByteArray, cipherAlgotirhm: String): Cipher {
    val k = toKey(key)
    val cipher = Cipher.getInstance(cipherAlgotirhm)
    val cipherAlgorithm = cipherAlgotirhm.toUpperCase()
    if (cipherAlgorithm.contains("CFB") || cipherAlgorithm.contains("CBC")
        || cipherAlgorithm.contains("CTR")
    )
        cipher.init(mode, k, IvParameterSpec(iv))
    else
        cipher.init(mode, k)
    return cipher
}

fun handleFile(
    mode: Int,
    key: ByteArray,
    iv: ByteArray,
    cipherAlgotirhm: String = AES_CFB_NOPADDING,
    sourceFilePath: String,
    destFilePath: String
): File? {
    val sourceFile = File(sourceFilePath)
    val destFile = File(destFilePath)

    if (sourceFile.exists() && sourceFile.isFile) {
        if (!destFile.parentFile.exists()) destFile.parentFile.mkdirs()
        destFile.createNewFile()

        val inputStream = FileInputStream(sourceFile)
        val outputStream = FileOutputStream(destFile)
        val cipher = initCipher(mode, key, iv, cipherAlgotirhm)
        val cin = CipherInputStream(inputStream, cipher)

        val b = ByteArray(1024)
        var read = 0
        do {
            read = cin.read(b)
            if (read > 0)
                outputStream.write(b, 0, read)
        } while (read > 0)

        outputStream.flush()
        cin.close()
        inputStream.close()
        outputStream.close()

        return destFile
    }
    return null
}

