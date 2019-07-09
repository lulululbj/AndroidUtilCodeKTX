package luyao.util.ktx.ui

import android.app.Activity
import kotlinx.android.synthetic.main.activity_another.*
import kotlinx.android.synthetic.main.title_layout.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.toast

/**
 * Created by luyao
 * on 2019/7/9 14:32
 */
class AnotherActivity : BaseActivity() {

    private val int by lazy { intent.getIntExtra("int", 0) }
    private val boolean by lazy { intent.getBooleanExtra("boolean", false) }
    private val string by lazy { intent.getStringExtra("string") }

    override fun getLayoutResId() = R.layout.activity_another

    override fun initView() {
        mToolbar.title = "AnotherActivity"

        toast("$int\n$boolean\n$string")
    }

    override fun initData() {
        finish.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}