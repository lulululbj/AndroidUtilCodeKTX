package luyao.util.ktx.ui

import android.os.Handler
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.loge
import luyao.util.ktx.lifecycle.KtxHandler

/**
 * Created by luyao
 * on 2019/8/6 9:43
 */
class LifeCycleActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_lifecycle

    override fun initView() {
        myHandler.sendEmptyMessageDelayed(10, 5 * 1000)
    }

    override fun initData() {
    }

    private val myHandler = KtxHandler(this, Handler.Callback {
        "receive from handler : ${it.what}".loge()
        true
    })

}