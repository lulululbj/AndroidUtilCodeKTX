package luyao.util.ktx.ext

import android.util.Log

/**
 * Created by luyao
 * on 2019/7/3 15:37
 */

const val TAG = "ktx"

private enum class LEVEL {
    V, D, I, W, E
}

fun String.v(tag: String = TAG, message: String) = log(LEVEL.V, tag, message)
fun String.d(tag: String = TAG, message: String) = log(LEVEL.D, tag, message)
fun String.i(tag: String = TAG, message: String) = log(LEVEL.I, tag, message)
fun String.w(tag: String = TAG, message: String) = log(LEVEL.W, tag, message)
fun String.e(tag: String = TAG, message: String) = log(LEVEL.E, tag, message)

private fun log(level: LEVEL, tag: String, message: String) {
    when (level) {
        LEVEL.V -> Log.v(tag, message)
        LEVEL.D -> Log.d(tag, message)
        LEVEL.I -> Log.i(tag, message)
        LEVEL.W -> Log.w(tag, message)
        LEVEL.E -> Log.e(tag, message)
    }
}