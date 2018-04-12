package mocaris.com.loopviewpagerlib;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * 无限轮播 viewPager
 */
public abstract class LoopViewPagerAdapter<T> extends PagerAdapter {

    protected Context context;
    protected ViewPager viewPager;
    protected boolean loop;

    protected List<T> mDatas;

    public LoopViewPagerAdapter(Context context, ViewPager viewPager, boolean loop) {
        this.context = context;
        this.viewPager = viewPager;
        this.loop = loop;
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public void setDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return loop ? Integer.MAX_VALUE : null == mDatas ? 0 : mDatas.size();
    }

    public int getItemCount() {
        return null == mDatas ? 0 : mDatas.size();
    }

    public void loop() {
        if (loop) {
            int count = getCount();
            viewPager.setCurrentItem(count / 2 - (count / 2) % getItemCount());
            viewPager.setOffscreenPageLimit(2);
        }
    }
}
