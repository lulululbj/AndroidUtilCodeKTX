package luyao.util.ktx.ui

import luyao.util.ktx.bean.ItemBean

/**
 * Created by luyao
 * on 2019/6/10 10:00
 */
class ExtActivity : CommonListActivity() {

    override fun getToolbarTitle() = "扩展函数"

    override fun initList() {
        dataList.run {
            add(ItemBean("ToastExt", ToastExtActivity::class.java))
            add(ItemBean("AppExt", ToastExtActivity::class.java))
            add(ItemBean("IntentExt", IntentExtActivity::class.java))
        }
    }


}