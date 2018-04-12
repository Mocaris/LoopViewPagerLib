package mocaris.com.demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    private lateinit var loopAdapter: LoopAdapter;
    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    @SuppressLint("SetTextI18n")
    override fun onPageSelected(position: Int) {

        tvIndex.setText("${vp.currentItem}/${loopAdapter.count}   $position")
//        tvIndex.setText("${vp.currentItem % loopAdapter.getitemCount() + 1}/${loopAdapter.getitemCount()} ----$position")
//        if (position == 0) {
//            vp.currentItem == loopAdapter.count / 2
//        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        btn0.setOnClickListener({ view: View? ->
//            vp.setCurrentItem(loopAdapter.count / 2 - (loopAdapter.count / 2) % loopAdapter.getitemCount(), false)
//        })
//        btnend.setOnClickListener({ view: View? ->
//            vp?.setCurrentItem(loopAdapter.count / 2 - (loopAdapter.count / 2) % loopAdapter.getitemCount() + loopAdapter.getitemCount(), false)
//        })
        loopAdapter = LoopAdapter(this@MainActivity, vp)
        val arrayList = listOf<String>("http://pic48.nipic.com/file/20140913/2531170_154901819000_2.jpg"
                , "http://img.taopic.com/uploads/allimg/120719/201514-120G920361668.jpg"
                , "http://img3.3lian.com/2013/c2/26/d/72.jpg"
                , "http://58pic.ooopic.com/58pic/16/34/92/06T58PIC5bf.jpg"
                , "http://pic31.photophoto.cn/20140413/0008020224865544_b.jpg"
                , "http://img3.3lian.com/2013/c2/26/d/72.jpg"
                , "http://pic2.ooopic.com/12/43/87/00bOOOPIC00.jpg")
        loopAdapter.mDatas = arrayList.toList()
        vp.addOnPageChangeListener(this@MainActivity)
        vp.adapter = loopAdapter
        vp.currentItem = 1
//        loopAdapter.loop()

    }
}
