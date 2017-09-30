
package com.curry.wsd.advertisementbanner.basetransforms;

import android.view.View;

/**
 * Created by WuSongDa on 2017/9/30.
 * author: WuSongDa
 */
public class StackTransformer extends ABaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		view.setTranslationX(position < 0 ? 0f : -view.getWidth() * position);
	}

}
