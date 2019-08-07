package luyao.util.ktx.core.span

import android.graphics.Typeface
import android.text.Layout
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.*
import android.widget.TextView

/**
 * Created by luyao
 * on 2019/8/6 16:46
 */
class KtxSpan {
    private val LINE_SEPARATOR = System.getProperty("line.separator")
    private var mText: CharSequence = ""
    private var mTextSize : Int = -1
    private var mLineHeight = -1
    private var mForegroundColor = -1
    private var mBackgroundColor = -1
    private var isBold = false
    private var mAlignment: Layout.Alignment? = null
    private var mFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE

    lateinit var mTextView: TextView
    val mSpanBuilder by lazy { SpannableStringBuilder() }

    fun with(view: TextView): KtxSpan {
        this.mTextView = view
        return this
    }

    fun text(
        text: CharSequence,
        textSize:Int = -1,
        lineHeight: Int = -1,
        foregroundColor: Int = -1,
        backgroundColor: Int = -1,
        alignment: Layout.Alignment? = null
    ): KtxSpan {
        mText = "$text$LINE_SEPARATOR"
        mTextSize = textSize
        mLineHeight = lineHeight
        mForegroundColor = foregroundColor
        mBackgroundColor = backgroundColor
        mAlignment = alignment
        updateSpan()
        return this
    }

    private fun updateSpan() {
        if (mText.isEmpty()) return
        val start = mSpanBuilder.length
        mSpanBuilder.append(mText)
        val end = mSpanBuilder.length

        if (mTextSize != -1)
            mSpanBuilder.setSpan(AbsoluteSizeSpan(mTextSize,true),start,end,mFlag)

        if (mLineHeight != -1)
            mSpanBuilder.setSpan(KtxLineHeightSpan(mLineHeight,KtxLineHeightSpan.ALIGN_CENTER), start, end, mFlag)

        if (mForegroundColor != -1)
            mSpanBuilder.setSpan(ForegroundColorSpan(mForegroundColor), start, end, mFlag)

        if (mBackgroundColor != -1)
            mSpanBuilder.setSpan(BackgroundColorSpan(mBackgroundColor), start, end, mFlag)

        if (isBold)
            mSpanBuilder.setSpan(StyleSpan(Typeface.BOLD), start, end, mFlag)

        mAlignment?.let { mSpanBuilder.setSpan(AlignmentSpan.Standard(it), start, end, mFlag) }
    }

    inline fun show(func: KtxSpan.() -> Unit): KtxSpan {
        func()
        mTextView.text = mSpanBuilder
        return this
    }
}

