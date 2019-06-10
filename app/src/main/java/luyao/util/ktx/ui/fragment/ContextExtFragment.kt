package luyao.util.ktx.ui.fragment

import luyao.util.ktx.ext.getVersionName
import luyao.util.ktx.ext.toast

/**
 * Created by luyao
 * on 2019/6/10 10:46
 */
class ContextExtFragment : CommonFragment() {

    override fun fillList() {
        dataList.add("toast")
        dataList.add("getVersionName")
    }

    override fun handleClick(position: Int) {
        context?.run {
            when (position) {
                0 -> toast("I'am a short toast!")
                1 -> toast(getVersionName())
            }
        }
    }
}