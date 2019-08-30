package luyao.util.ktx.ext.listener

import androidx.viewpager.widget.ViewPager

/**
 * Created by luyao
 * on 2019/8/30 16:31
 */
fun ViewPager.onPageSelected(pageChangedAction: (newPosition: Int) -> Unit) =
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {}

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

        override fun onPageSelected(position: Int) {
            pageChangedAction(position)
        }
    })
