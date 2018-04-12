package mocaris.com.demo

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup

abstract class LoopViewPagerAdapter<T>(val context: Context, val viewPager: ViewPager, val loop: Boolean) : PagerAdapter() {


    lateinit var mDatas: List<T>

//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view == `object`
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        container.removeView(`object` as View?)
//    }

    override fun getCount(): Int {
        return if (loop) Int.MAX_VALUE - Int.MAX_VALUE % mDatas.size else mDatas?.size
    }

    fun getitemCount(): Int {
        return mDatas?.size ?: 0
    }

    fun getItem(position: Int): T {
        return mDatas?.get(position % mDatas.size)
    }

    /**
     * 无限轮播
     * 从第一屏开始
     */
    fun loop() {
        if (loop) {
            viewPager?.setCurrentItem(count / 2 - (count / 2) % getitemCount(), false)
            viewPager.offscreenPageLimit = 2
        }
    }
}