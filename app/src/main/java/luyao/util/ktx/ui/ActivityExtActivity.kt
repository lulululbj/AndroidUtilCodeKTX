package luyao.util.ktx.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_activity_ext.*
import kotlinx.android.synthetic.main.title_layout.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.startKtxActivity
import luyao.util.ktx.ext.startKtxActivityForResult
import luyao.util.ktx.ext.toast

/**
 * Created by luyao
 * on 2019/7/9 14:29
 */
class ActivityExtActivity : BaseActivity() {
    override fun getLayoutResId() = R.layout.activity_activity_ext

    override fun initView() {
        mToolbar.title = "ActivityExt"
    }

    override fun initData() {
        startActivity.setOnClickListener {
            startKtxActivity<AnotherActivity>()
        }

        startActivityWithFlag.setOnClickListener {
            startKtxActivity<AnotherActivity>(flag = Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        startActivityForResult.setOnClickListener {
            startKtxActivityForResult<AnotherActivity>(requestCode = 1024)
        }

        startActivityWithValue.setOnClickListener {
            startKtxActivity<AnotherActivity>("string" to "single value")
        }

        startActivityWithMultiValue.setOnClickListener {
            startKtxActivity<AnotherActivity>(
                "int" to 1,
                "boolean" to true,
                "string" to "multi value"
            )
        }

        startActivityWithBundle.setOnClickListener {
            startKtxActivity<AnotherActivity>(
                extra = Bundle().apply {
                    putInt("int", 2)
                    putBoolean("boolean", true)
                    putString("string", "from bundle")
                }
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ((resultCode == Activity.RESULT_OK) and (requestCode == 1024)) {
            toast("onActivityResult")
        }

    }
}