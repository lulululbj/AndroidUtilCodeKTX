package luyao.util.ktx

import kotlinx.android.synthetic.main.activity_main.*
import luyao.ktx.R
import luyao.ktx.base.BaseActivity
import luyao.util.ktx.mvvm.MvvmActivity

class MainActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_main

    override fun initView() {}

    override fun initData() {
        btMvvm.setOnClickListener { startActivity(MvvmActivity::class.java) }
    }
}
