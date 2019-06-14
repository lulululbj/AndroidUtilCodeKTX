package luyao.util.ktx.ui

import kotlinx.android.synthetic.main.activity_toast_ext.*
import kotlinx.android.synthetic.main.title_layout.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.longToast
import luyao.util.ktx.ext.toast

/**
 * Created by luyao
 * on 2019/6/14 14:36
 */
class ToastExtActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_toast_ext

    override fun initView() {
        mToolbar.title = "ToastExt"
    }

    override fun initData() {
        toastBt.setOnClickListener { toast("I am groot.") }
        longToastBt.setOnClickListener { longToast(R.string.groot) }

    }
}