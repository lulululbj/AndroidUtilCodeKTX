package luyao.util.ktx.ui

import android.graphics.Color
import android.text.Layout
import kotlinx.android.synthetic.main.activity_ktx_span.*
import kotlinx.android.synthetic.main.title_layout.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.core.span.KtxSpan

/**
 * Created by luyao
 * on 2019/8/7 14:07
 */
class KtxSpanActivity : BaseActivity() {

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
            text("字体大小", textSize = 40)
        }
    }
}