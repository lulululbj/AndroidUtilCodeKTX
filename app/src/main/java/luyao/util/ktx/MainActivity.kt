package luyao.util.ktx

import kotlinx.android.synthetic.main.activity_main.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.startKtxActivity
import luyao.util.ktx.mvvm.MvvmActivity
import luyao.util.ktx.ui.ExtActivity

class MainActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_main

    override fun initView() {}

    override fun initData() {
        btMvvm.setOnClickListener { startKtxActivity<MvvmActivity>() }
        btExt.setOnClickListener { startKtxActivity<ExtActivity>()}
    }
}
