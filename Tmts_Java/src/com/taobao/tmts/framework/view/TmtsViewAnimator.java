package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.ViewAnimator;

public class TmtsViewAnimator extends TmtsFrameLayout {
	private static final String LOG_TAG = "TmtsViewAnimator";
	private ViewAnimator viewAnimator;

	public TmtsViewAnimator(Instrumentation inst, ViewAnimator viewAnimator) {
		super(inst, viewAnimator);
		this.viewAnimator = viewAnimator;
	}
}
