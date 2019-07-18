package luyao.util.ktx.ui

import kotlinx.android.synthetic.main.activity_common_ext.*
import kotlinx.android.synthetic.main.title_layout.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.copyToClipboard
import luyao.util.ktx.ext.screenHeight
import luyao.util.ktx.ext.screenWidth
import luyao.util.ktx.ext.toast

/**
 * Created by luyao
 * on 2019/7/17 15:26
 */
class CommonExtActivity  : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_common_ext

    override fun initView() {
        mToolbar.title = "CommonExt"
    }

    override fun initData() {
        screenWidthBt.text = "screen width : $screenWidth"
        screenHeightBt.text = "screen height : $screenHeight"
        copyBt.setOnClickListener {
            val content = copyEt.text.toString()
            if (content.isNotEmpty()){
                copyToClipboard("ktx",content)
            }else {
                toast("please input some words")
            }
        }

    }
}