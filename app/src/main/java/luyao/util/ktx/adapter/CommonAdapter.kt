package luyao.util.ktx.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import luyao.ktx.R

/**
 * Created by luyao
 * on 2019/6/10 10:57
 */
class CommonAdapter(layoutResId: Int = R.layout.item_common) : BaseQuickAdapter<String, BaseViewHolder>(layoutResId) {

    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.itemTv, item)
    }
}