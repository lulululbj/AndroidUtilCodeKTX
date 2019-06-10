package luyao.util.ktx.mvvm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_mvvm_demo.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseVMActivity
import luyao.util.ktx.ext.toast

/**
 * Created by luyao
 * on 2019/5/31 16:28
 */
class MvvmActivity : BaseVMActivity<MvvmModel>(), LifecycleOwner {

    override fun providerVMClass() = MvvmModel::class.java

    override fun getLayoutResId() = R.layout.activity_mvvm_demo

    override fun initView() {
        mvvm.setOnClickListener { mViewModel.getMessage() }
    }

    override fun initData() {

    }

    override fun startObserve() {
        mViewModel.run {
            mMessage.observe(this@MvvmActivity, Observer {
                it?.run {
                    toast(it)
                }
            })
        }
    }
}