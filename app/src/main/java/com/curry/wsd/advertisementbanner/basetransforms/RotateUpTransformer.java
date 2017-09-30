
package com.curry.wsd.advertisementbanner.basetransforms;

import android.view.View;

/**
 * Created by WuSongDa on 2017/9/30.
 * author: WuSongDa
 */
public class RotateUpTransformer extends ABaseTransformer {

	private static final float ROT_MOD = -15f;

	@Override
	protected void onTransform(View view, float position) {
		final float width = view.getWidth();
		final float rotation = ROT_MOD * position;

		view.setPivotX(width * 0.5f);
		view.setPivotY(0f);
		view.setTranslationX(0f);
		view.setRotation(rotation);
	}
	
	@Override
	protected boolean isPagingEnabled() {
		return true;
	}

}
