package luyao.util.ktx.ui

import kotlinx.android.synthetic.main.activity_shell_ext.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.executeCmd
import luyao.util.ktx.ext.toast
import luyao.util.ktx.ext.view.notEmpty

/**
 * Created by luyao
 * on 2019/7/18 15:50
 */
class ShellExtActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_shell_ext

    override fun initView() {
    }

    override fun initData() {

        commandBt.setOnClickListener {
           commandEt.notEmpty(
               {
                   commandTv.text = executeCmd(text.toString())
               },
               {
                    toast("Please input command")
               }
           )

        }
    }


}