package luyao.ktx.ext

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * Created by luyao
 * on 2019/5/31 16:42
 */

var showToast: Toast? = null

fun Context.toast(content: String, duration: Int = Toast.LENGTH_SHORT) {
    showToast?.apply {
        setText(content)
        show()
    } ?: run {
        Toast.makeText(this.applicationContext, content, Toast.LENGTH_SHORT).apply {
            showToast = this
        }.show()
    }
}

fun Context.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) {
    toast(getString(id), duration)
}
