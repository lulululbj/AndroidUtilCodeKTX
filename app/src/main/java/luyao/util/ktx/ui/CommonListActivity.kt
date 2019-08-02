package luyao.util.ktx.ui

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_common_list.*
import kotlinx.android.synthetic.main.title_layout.*
import luyao.ktx.R
import luyao.util.ktx.adapter.CommonAdapter
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.bean.ItemBean
import luyao.util.ktx.ext.view.itemPadding

/**
 * Created by luyao
 * on 2019/6/18 10:27
 */
abstract class CommonListActivity : BaseActivity() {

    open val dataList = ArrayList<ItemBean>()
    private val commonAdapter by lazy { CommonAdapter() }

    override fun getLayoutResId() = R.layout.activity_common_list

    override fun initView() {
        initList()
        mToolbar.run {
            title = getToolbarTitle()
            setNavigationIcon(R.drawable.arrow_back)
        }
        initRecycleView()
    }

    override fun initData() {
        commonAdapter.setNewData(dataList)
    }

    private fun initRecycleView() {

        commonAdapter.setOnItemClickListener { _, _, position ->
            dataList[position].z?.let { startActivity(it) }
            handleClick(position)
        }

        commonRecycleView.run {
            itemPadding(5, 5, 10, 10)
            layoutManager = LinearLayoutManager(this@CommonListActivity)
            adapter = commonAdapter
        }
    }

    abstract fun getToolbarTitle(): String
    abstract fun initList()
    open fun handleClick(position:Int) {}
}