package com.curry.wsd.advertisementbanner.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.curry.wsd.advertisementbanner.R;
import com.curry.wsd.advertisementbanner.holder.Holder;

/**
 * 网络图片加载例子
 */
public class NetworkImageHolderView implements Holder<String> {
    private ImageView imageView;
    @Override
    public View createView(Context context) {
        //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context,int position, String data) {
        Glide.with(context).load(data).placeholder(R.mipmap.ic_default_adimage).error(R.mipmap.ic_default_adimage).into(imageView);
    }
}
