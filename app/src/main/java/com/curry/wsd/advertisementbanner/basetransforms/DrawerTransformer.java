package com.curry.wsd.advertisementbanner.basetransforms;

import android.view.View;

/**
 * Created by WuSongDa on 2017/9/30.
 * author: WuSongDa
 */
public class DrawerTransformer extends ABaseTransformer {
    @Override
    protected void onTransform(View view, float position) {
        if (position <= 0) {
            view.setTranslationX(0);
        } else if (position > 0 && position <= 1) {
            view.setTranslationX(-view.getWidth() / 2 * position);
        }
    }
}
