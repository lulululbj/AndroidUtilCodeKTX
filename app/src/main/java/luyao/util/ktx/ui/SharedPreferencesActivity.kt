package luyao.util.ktx.ui

import kotlinx.android.synthetic.main.activity_sharedperferences.*
import kotlinx.android.synthetic.main.title_layout.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.bean.Person
import luyao.util.ktx.ext.sp.getSpValue
import luyao.util.ktx.ext.sp.putSpValue
import luyao.util.ktx.ext.toast

/**
 * Created by luyao
 * on 2019/7/8 15:04
 */
class SharedPreferencesActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_sharedperferences

    override fun initView() {
        mToolbar.title = "SharedPreferencesExt"
    }

    override fun initData() {

        putInt.setOnClickListener {
            putSpValue("int", 1)
            toast(getSpValue("int", 0).toString())
        }
        putFloat.setOnClickListener {
            putSpValue("float", 1f)
            toast(getSpValue("float", 0f).toString())
        }
        putBoolean.setOnClickListener {
            putSpValue("boolean", true)
            toast(getSpValue("boolean", false).toString())
        }
        putString.setOnClickListener {
            putSpValue("string", "ktx")
            toast(getSpValue("string", "null"))
        }
        putSerializable.setOnClickListener {
            putSpValue("serialize", Person("Man", 3))
            toast(getSpValue("serialize", Person("default", 0)).toString())
        }
        putMulti.setOnClickListener {
            putSpValue("tag1", 1)
            putSpValue("tag2", false)
            putSpValue("tag3", Person("bingxin", 1))
            toast("${getSpValue("tag1",0)}\n" +
                    "${getSpValue("tag2",true)}\n" +
                    "${getSpValue("tag3",Person("default",0))}")
        }
    }
}