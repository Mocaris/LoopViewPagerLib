package mocaris.com.loopviewpagerlib;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 无限轮播 viewPager
 */
public abstract class LoopViewPagerAdapter2<T> extends PagerAdapter implements ViewPager.OnPageChangeListener {

    protected Context context;
    protected ViewPager viewPager;
    protected List<T> mDatas;
    private List<T> provideList = new ArrayList<>();

    public LoopViewPagerAdapter2(Context context, ViewPager viewPager) {
        this.context = context;
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public void setDatas(List<T> datas) {
        this.mDatas = datas;
        if (!provideList.isEmpty()) {
            provideList.clear();
        }
        provideList.addAll(datas);
        provideList.add(provideList.size() - 1, datas.get(0));//添加第一个
        provideList.add(0, datas.get(datas.size() - 1));//添加最后一个
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return provideList.size();
    }

    public T getItem(int position) {
        if (position == 0) {
            return mDatas.get(mDatas.size() - 1);
        } else if (position == getCount() - 1) {
            return mDatas.get(0);
        }
        return mDatas.get(position - 1);
    }

    @Override
    public void onPageSelected(int position) {
        int count = getCount();
        if (count != 0) {
            if (position == 0) {
                viewPager.setCurrentItem(count - 2, false);
            } else if (position == count - 1) {
                viewPager.setCurrentItem(1, false);
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
