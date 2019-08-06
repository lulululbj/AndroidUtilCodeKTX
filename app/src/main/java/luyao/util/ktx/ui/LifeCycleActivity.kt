package luyao.util.ktx.ui

import android.os.Handler
import kotlinx.android.synthetic.main.activity_lifecycle.*
import luyao.ktx.R
import luyao.util.ktx.MainActivity
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.loge
import luyao.util.ktx.ext.toast
import luyao.util.ktx.core.lifecycle.KtxHandler
import luyao.util.ktx.core.lifecycle.KtxManager

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
        currentActivityBt.setOnClickListener { KtxManager.currentActivity?.let { toast(it.localClassName) } }
        finishMainBt.setOnClickListener { KtxManager.finishActivity(MainActivity::class.java) }
        finishAllBt.setOnClickListener { KtxManager.finishAllActivity() }
    }

    private val myHandler = KtxHandler(this, Handler.Callback {
        "receive from handler : ${it.what}".loge()
        true
    })

}