package luyao.util.ktx.ext.view

import android.widget.TextView

/**
 * Created by luyao
 * on 2019/7/18 15:59
 */
fun TextView.notEmpty(f: TextView.() -> Unit, t: TextView.() -> Unit) {
    if (text.toString().isNotEmpty()) f() else t()
}