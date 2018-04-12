package mocaris.com.demo

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager

abstract class LoopViewPagerAdapter2<T>(val context: Context, val viewPager: ViewPager) : PagerAdapter(), ViewPager.OnPageChangeListener {
    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        if (count != 0) {
            if (position == 0) {
                viewPager.setCurrentItem(count - 2, false)
            } else if (position == count - 1) {
                viewPager.setCurrentItem(1, false)
            }
        }
    }

    private val proverList: ArrayList<T> = ArrayList<T>()
    var mDatas: List<T> = ArrayList<T>()
        set(value) {
            field = value
            if (value.isNotEmpty()) {
                proverList.clear();
                proverList.addAll(field)
                proverList.add(proverList.lastIndex, value.first())//添加第一个
                proverList.add(0, value.last())//添加最后一个
            } else {
                proverList.clear()
            }
            notifyDataSetChanged()
        }

    init {
        viewPager.addOnPageChangeListener(this@LoopViewPagerAdapter2)
    }

    override fun getCount(): Int {
        return proverList?.size ?: 0
    }

    fun getItem(position: Int): T {
        if (position == 0) {
            return mDatas.last()
        } else if (position == count - 1) {
            return mDatas.first()
        }
        return mDatas[position - 1]
    }

    /**
     * 无限轮播
     * 从第一屏开始
     */
}