
package com.curry.wsd.advertisementbanner.basetransforms;

import android.view.View;

/**
 * Created by WuSongDa on 2017/9/30.
 * author: WuSongDa
 */
public class AccordionTransformer extends ABaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		view.setPivotX(position < 0 ? 0 : view.getWidth());
		view.setScaleX(position < 0 ? 1f + position : 1f - position);
	}

}
