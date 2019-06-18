package luyao.util.ktx.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import luyao.ktx.R
import luyao.util.ktx.bean.ItemBean

/**
 * Created by luyao
 * on 2019/6/10 10:57
 */
class CommonAdapter(layoutResId: Int = R.layout.item_common) : BaseQuickAdapter<ItemBean, BaseViewHolder>(layoutResId) {

    override fun convert(helper: BaseViewHolder, item: ItemBean) {
        helper.setText(R.id.itemTv, item.name)
    }
}