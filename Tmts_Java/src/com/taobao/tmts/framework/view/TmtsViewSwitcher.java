package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.ViewSwitcher;

public class TmtsViewSwitcher extends TmtsViewAnimator {
	private static final String LOG_TAG = "TmtsViewSwitcher";
	private ViewSwitcher viewSwitcher;

	public TmtsViewSwitcher(Instrumentation inst, ViewSwitcher viewSwitcher) {
		super(inst, viewSwitcher);
		this.viewSwitcher = viewSwitcher;
	}

}
