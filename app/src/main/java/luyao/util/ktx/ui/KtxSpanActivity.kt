package luyao.util.ktx.ui

import android.graphics.BlurMaskFilter
import android.graphics.Color
import android.graphics.Typeface
import android.text.Layout
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.ImageSpan
import android.view.View
import kotlinx.android.synthetic.main.activity_ktx_span.*
import kotlinx.android.synthetic.main.title_layout.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.core.span.KtxImageSpan
import luyao.util.ktx.core.span.KtxSpan
import luyao.util.ktx.ext.dp2px
import luyao.util.ktx.ext.toast

/**
 * Created by luyao
 * on 2019/8/7 14:07
 */
class KtxSpanActivity : BaseActivity() {

    private val TYPEFACE_RMB by lazy {
        val tempRmb = Typeface.createFromAsset(assets, "fonts/iconfont.ttf")
        Typeface.create(tempRmb, Typeface.NORMAL)
    }

    private val clickSpan = object : ClickableSpan() {
        override fun onClick(widget: View) {
            toast("Clicked !")
        }

        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.isUnderlineText = true
        }
    }

    override fun getLayoutResId() = R.layout.activity_ktx_span

    override fun initView() {
        mToolbar.title = "KtxSpan"
        setKtxSpan()
    }

    override fun initData() {
    }

    private fun setKtxSpan() {
        KtxSpan().with(spanTv).show {
            text(
                "SpanUtils",
                foregroundColor = Color.YELLOW,
                backgroundColor = Color.LTGRAY,
                alignment = Layout.Alignment.ALIGN_CENTER
            )
            text("前景色", foregroundColor = Color.GREEN)
            text("背景色", backgroundColor = Color.LTGRAY)
            blankLine(spanTv.dp2px(6), true)
            text("行高", lineHeight = 2 * spanTv.lineHeight, backgroundColor = Color.LTGRAY)
            text(
                "测试段落缩进，首行缩进两字，其他行不缩进，其他行不缩进",
                first = (spanTv.textSize * 2).toInt(),
                rest = 0,
                backgroundColor = Color.GREEN
            )
            text(
                "测试引用，后面的字是为了凑到两行的效果",
                quoteColor = Color.GREEN,
                quoteStripeWidth = 10,
                quoteGapWidth = 10,
                backgroundColor = Color.LTGRAY
            )
            text(
                "测试列表项，后面的字是为了凑到两行的效果",
                bulletColor = Color.GREEN,
                bulletRadius = 20,
                bulletGapWidth = 10,
                backgroundColor = Color.LTGRAY
            )
            text("32 dp 字体大小", textSize = 40)
            text("32 px 字体大小", textSize = 40, isDp = false)
            text("2 倍字体", fontProportion = 2f)
            text("横向两倍字体", xFontProportion = 2f)
            text("删除线", isStrikethrough = true)
            text("下划线", isUnderline = true)
            text("粗体", isBold = true)
            text("斜体", isItalic = true)
            text("粗体 && 斜体", isBoldAndItalic = true)
            text("下标 CO", isNewLine = false)
            text("2", isSubscript = true)
            text("上标 x", isNewLine = false)
            text("2", isSuperscript = true)
            text("字体 serif ¥", fontFamily = "serif")
            text("自定义字体 ¥", customTypeFace = TYPEFACE_RMB)
            text("相反对齐", alignment = Layout.Alignment.ALIGN_OPPOSITE)
            text("居中对齐", alignment = Layout.Alignment.ALIGN_CENTER)
            text("正常对齐", alignment = Layout.Alignment.ALIGN_NORMAL)
            text("测试", isNewLine = false)
            text(" 点击事件", clickSpan = clickSpan, isNewLine = false)
            text(" 测试")
            text("点我一下 ！", foregroundColor = Color.GREEN, url = "https://github.com/lulululbj/AndroidUtilCodeKTX")
            text("模糊效果", blurRadius = 5f, blurStyle = BlurMaskFilter.Blur.NORMAL)
            text("图片 ", isNewLine = false)
            image(R.drawable.small, verticalAlignment = KtxImageSpan.ALIGN_MIDDLE)
            text(" 居中显示")
            text("图片 ", isNewLine = false)
            image(R.drawable.small, verticalAlignment = ImageSpan.ALIGN_BOTTOM)
            text(" 底部显示")
            text("图片 ", isNewLine = false)
            image(R.drawable.small, verticalAlignment = ImageSpan.ALIGN_BASELINE)
            text(" baseline 显示")
            text("marginLeft:10dp", isNewLine = false)
            image(R.drawable.small, marginLeft = dp2px(10), marginRight = dp2px(20))
            text(" marginRight:20dp")
            text("图片 marginLeft:20dp", isNewLine = false)
            image(
                R.drawable.small,
                verticalAlignment = ImageSpan.ALIGN_BASELINE,
                marginLeft = dp2px(20),
                marginRight = dp2px(30)
            )
            text(" marginRight:30dp")
            text("图片 marginLeft:30dp", isNewLine = false)
            image(
                R.drawable.small,
                verticalAlignment = ImageSpan.ALIGN_BOTTOM,
                marginLeft = dp2px(30),
                marginRight = dp2px(40)
            )
            text(" marginRight:40dp")
        }
    }
}