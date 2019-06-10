package luyao.util.ktx.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_ext.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ui.fragment.ContextExtFragment

/**
 * Created by luyao
 * on 2019/6/10 10:00
 */
class ExtActivity : BaseActivity() {

    private val titleList = arrayOf("Context", "String")
    private val fragmentList = arrayListOf<Fragment>()

    private val contextExtFragment = ContextExtFragment()
    private val stringExtFragment = ContextExtFragment()


    override fun getLayoutResId() = R.layout.activity_ext

    init {
        fragmentList.add(contextExtFragment)
        fragmentList.add(stringExtFragment)
    }

    override fun initView() {
        mToolbar.run {
            title = "扩展函数"
            setNavigationIcon(R.drawable.arrow_back)
        }

        initViewPager()
    }

    override fun initData() {
    }

    private fun initViewPager() {
        extViewPager.adapter =
            object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
                override fun getItem(position: Int) = fragmentList[position]

                override fun getCount() = fragmentList.size

                override fun getPageTitle(position: Int) = titleList[position]
            }
        extTabLayout.setupWithViewPager(extViewPager)
    }
}