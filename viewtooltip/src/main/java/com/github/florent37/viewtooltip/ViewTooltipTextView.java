package com.github.florent37.viewtooltip;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Matt on 09/01/2018.
 */

class ViewTooltipTextView extends AppCompatTextView {
	public ViewTooltipTextView(Context context) {
		super(context);
	}

	public ViewTooltipTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ViewTooltipTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		Layout layout = getLayout();
		if (layout != null) {
			int width = (int) Math.ceil(getMaxLineWidth(layout))
					+ getCompoundPaddingLeft() + getCompoundPaddingRight();
			if (width < getMeasuredWidth()){
				super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.getMode(widthMeasureSpec)), heightMeasureSpec);
			}
		}
	}

	private float getMaxLineWidth(Layout layout) {
		float max_width = 0.0f;
		int lines = layout.getLineCount();
		for (int i = 0; i < lines; i++) {
			if (layout.getLineWidth(i) > max_width) {
				max_width = layout.getLineWidth(i);
			}
		}
		return max_width;
	}
}
