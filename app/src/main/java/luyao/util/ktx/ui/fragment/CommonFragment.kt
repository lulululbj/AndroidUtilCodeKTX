package luyao.util.ktx.ui.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_context_ext.*
import luyao.ktx.R
import luyao.util.ktx.adapter.CommonAdapter
import luyao.util.ktx.base.BaseFragment
import luyao.util.ktx.bean.ItemBean

/**
 * Created by luyao
 * on 2019/6/10 13:18
 */
abstract class CommonFragment : BaseFragment() {

    open val dataList = ArrayList<ItemBean>()
    private val commonAdapter by lazy { CommonAdapter() }

    override fun getLayoutResId() = R.layout.fragment_context_ext

    override fun initView() {
        commonAdapter.setOnItemClickListener { _, _, position ->
            handleClick(position)
        }
        recycleView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = commonAdapter
        }
    }

    override fun initData() {
        fillList()
        commonAdapter.setNewData(dataList)
    }

    abstract fun fillList()
    abstract fun handleClick(position: Int)
}