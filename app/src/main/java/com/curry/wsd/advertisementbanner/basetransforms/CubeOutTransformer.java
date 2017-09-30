

package com.curry.wsd.advertisementbanner.basetransforms;

import android.view.View;

/**
 * Created by WuSongDa on 2017/9/30.
 * author: WuSongDa
 */
public class CubeOutTransformer extends ABaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		view.setPivotX(position < 0f ? view.getWidth() : 0f);
		view.setPivotY(view.getHeight() * 0.5f);
		view.setRotationY(90f * position);
	}

	@Override
	public boolean isPagingEnabled() {
		return true;
	}

}
