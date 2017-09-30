package com.curry.wsd.advertisementbanner.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.curry.wsd.advertisementbanner.R;
import com.curry.wsd.advertisementbanner.holder.AdViewHolderCreator;
import com.curry.wsd.advertisementbanner.holder.Holder;
import com.curry.wsd.advertisementbanner.view.AdLoopViewPager;

import java.util.List;

/**
 * The type Advert page adapter.
 * @param <T> the type parameter
 */
public class AdvertPageAdapter<T> extends PagerAdapter {
    protected List<T> mDatas;
    protected AdViewHolderCreator holderCreator;
//    private View.OnClickListener onItemClickListener;
    private boolean canLoop = true;
    private AdLoopViewPager viewPager;
    private final int MULTIPLE_COUNT = 300;

    /**
     * To real position int.
     *
     * @param position the position
     * @return the int
     */
    public int toRealPosition(int position) {
        int realCount = getRealCount();
        if (realCount == 0)
            return 0;
        int realPosition = position % realCount;
        return realPosition;
    }

    @Override
    public int getCount() {
        return canLoop ? getRealCount()*MULTIPLE_COUNT : getRealCount();
    }

    /**
     * Gets real count.
     *
     * @return the real count
     */
    public int getRealCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int realPosition = toRealPosition(position);

        View view = getView(realPosition, null, container);
//        if(onItemClickListener != null) view.setOnClickListener(onItemClickListener);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        int position = viewPager.getCurrentItem();
        if (position == 0) {
            position = viewPager.getFristItem();
        } else if (position == getCount() - 1) {
            position = viewPager.getLastItem();
        }
        try {
            viewPager.setCurrentItem(position, false);
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * Sets can loop.
     *
     * @param canLoop the can loop
     */
    public void setCanLoop(boolean canLoop) {
        this.canLoop = canLoop;
    }

    /**
     * Sets view pager.
     *
     * @param viewPager the view pager
     */
    public void setViewPager(AdLoopViewPager viewPager) {
        this.viewPager = viewPager;
    }

    /**
     * Instantiates a new Advert page adapter.
     *
     * @param holderCreator the holder creator
     * @param datas         the datas
     */
    public AdvertPageAdapter(AdViewHolderCreator holderCreator, List<T> datas) {
        this.holderCreator = holderCreator;
        this.mDatas = datas;
    }

    public View getView(int position, View view, ViewGroup container) {
        Holder holder = null;
        if (view == null) {
            holder = (Holder) holderCreator.createHolder();
            view = holder.createView(container.getContext());
            view.setTag(R.id.ad_item_tag, holder);
        } else {
            holder = (Holder<T>) view.getTag(R.id.ad_item_tag);
        }
        if (mDatas != null && !mDatas.isEmpty())
            holder.UpdateUI(container.getContext(), position, mDatas.get(position));
        return view;
    }

//    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }
}
