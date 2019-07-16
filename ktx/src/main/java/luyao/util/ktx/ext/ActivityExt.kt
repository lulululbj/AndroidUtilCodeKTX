package luyao.util.ktx.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by luyao
 * on 2019/7/9 14:17
 */
inline fun <reified T : Activity> Activity.startKtxActivity(flags: Int? = null, extra: Bundle? = null): Unit =
    startActivity(getIntent<T>(flags, extra))

inline fun <reified T : Activity> Activity.startKtxActivity(
    flags: Int? = null,
    extra: Bundle? = null,
    value: Pair<String, Any>?
): Unit =
    startActivity(getIntent<T>(flags, extra, arrayListOf(value)))

inline fun <reified T : Activity> Activity.startKtxActivity(
    flags: Int? = null,
    extra: Bundle? = null,
    values: List<Pair<String, Any>?>?
): Unit =
    startActivity(getIntent<T>(flags, extra, values))

inline fun <reified T : Activity> Activity.startKtxActivityForResult(
    requestCode: Int,
    flags: Int? = null,
    extra: Bundle? = null
): Unit =
    startActivityForResult(getIntent<T>(flags, extra), requestCode)

inline fun <reified T : Context> Activity.getIntent(flags: Int?, extra: Bundle?): Intent =
    Intent(this, T::class.java).apply {
        flags?.let { setFlags(flags) }
        extra?.let { putExtras(extra) }
    }

inline fun <reified T : Context> Activity.getIntent(
    flags: Int?,
    extra: Bundle?,
    pairs: List<Pair<String, Any>?>?
): Intent =
    Intent(this, T::class.java).apply {
        flags?.let { setFlags(flags) }
        extra?.let { putExtras(extra) }
        pairs?.let {
            for (pair in pairs)
                pair?.let {
                    val name = pair.first
                    when (val value = pair.second) {
                        is Int -> putExtra(name, value)
                        is Byte -> putExtra(name, value)
                        is Char -> putExtra(name, value)
                        is Short -> putExtra(name, value)
                        is Boolean -> putExtra(name, value)
                        is Long -> putExtra(name, value)
                        is Float -> putExtra(name, value)
                        is Double -> putExtra(name, value)
                        is String -> putExtra(name, value)
                        is CharSequence -> putExtra(name, value)
                        is Parcelable -> putExtra(name, value)
                        is Array<*> -> putExtra(name, value)
                        is ArrayList<*> -> putExtra(name, value)
                        is Serializable -> putExtra(name, value)
                        is BooleanArray -> putExtra(name, value)
                        is ByteArray -> putExtra(name, value)
                        is ShortArray -> putExtra(name, value)
                        is CharArray -> putExtra(name, value)
                        is IntArray -> putExtra(name, value)
                        is LongArray -> putExtra(name, value)
                        is FloatArray -> putExtra(name, value)
                        is DoubleArray -> putExtra(name, value)
                        is Bundle -> putExtra(name, value)
                        is Intent -> putExtra(name, value)
                        else -> {
                        }
                    }
                }
        }
    }