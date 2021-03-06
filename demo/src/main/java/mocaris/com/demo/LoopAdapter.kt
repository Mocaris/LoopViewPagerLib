package mocaris.com.demo

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import mocaris.com.loopviewpagerlib.LoopViewPagerAdapter2

//import com.bumptech.glide.Glide

class LoopAdapter(context: Context, viewPager: ViewPager) : LoopViewPagerAdapter2<String>(context, viewPager) {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_vp, container, false)
        val img = itemView.findViewById<ImageView>(R.id.img)
        img.disPlayByUrl(getItem(position))
        container.addView(itemView)
        return itemView
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}