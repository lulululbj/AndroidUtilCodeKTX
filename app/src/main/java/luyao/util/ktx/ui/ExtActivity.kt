package luyao.util.ktx.ui

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_ext.*
import kotlinx.android.synthetic.main.title_layout.*
import luyao.ktx.R
import luyao.util.ktx.adapter.CommonAdapter
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.itemPadding

/**
 * Created by luyao
 * on 2019/6/10 10:00
 */
class ExtActivity : BaseActivity() {

    private val dataList = ArrayList<String>()
    private val commonAdapter by lazy { CommonAdapter() }

    init {
        dataList.run {
            add("ToastExt")
            add("AppExt")
        }
    }

    override fun getLayoutResId() = R.layout.activity_ext


    override fun initView() {
        mToolbar.run {
            title = "扩展函数"
            setNavigationIcon(R.drawable.arrow_back)
        }

        initRecycleView()
    }

    override fun initData() {
        commonAdapter.setNewData(dataList)
    }

    private fun initRecycleView() {
        commonAdapter.setOnItemClickListener { _, _, position ->
            handleClick(position)
        }
        extRecycleView.run {
            itemPadding(5,5,10,10)
            layoutManager = LinearLayoutManager(this@ExtActivity)
            adapter = commonAdapter
        }
    }

    private fun handleClick(position: Int) {
        when (position) {
            0 -> startActivity(ToastExtActivity::class.java)
        }
    }
}