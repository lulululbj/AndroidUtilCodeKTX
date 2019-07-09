package luyao.util.ktx.ext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View

/**
 * Created by luyao
 * on 2019/6/14 14:23
 */

fun Context.dp2px(dp: Float): Int {
    val scale = resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}

fun Context.px2dp(px: Float): Int {
    val scale = resources.displayMetrics.density
    return (px / scale + 0.5f).toInt()
}

fun View.dp2px(dp: Float): Int {
    val scale = resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}

fun View.px2dp(px: Float): Int {
    val scale = resources.displayMetrics.density
    return (px / scale + 0.5f).toInt()
}


fun Context.getWidth() = resources.displayMetrics.widthPixels

fun Context.getHeight() = resources.displayMetrics.heightPixels

fun Context.copyToClipboard(text:String,label:String){
    val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clipData= ClipData.newPlainText(label,text)
    cm.primaryClip=clipData
}