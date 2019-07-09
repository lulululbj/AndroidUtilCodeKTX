package luyao.util.ktx.ui

import kotlinx.android.synthetic.main.activity_listener.*
import kotlinx.android.synthetic.main.title_layout.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.textWatcher
import luyao.util.ktx.ext.toast

/**
 * Created by luyao
 * on 2019/7/9 16:24
 */
class ListenerExtActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_listener

    override fun initView() {
        mToolbar.title = "ListenerExtActivity"
    }

    override fun initData() {
        listenerEt.textWatcher {
            onTextChanged { s, start, before, count ->
                toast(s.toString())
            }

            afterTextChanged { toast(it.toString()) }
        }
    }
}