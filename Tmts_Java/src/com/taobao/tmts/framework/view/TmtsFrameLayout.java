package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.FrameLayout;

public class TmtsFrameLayout extends TmtsViewGroup {
	private static final String LOG_TAG = "TmtsFrameLayout";
	private FrameLayout frameLayout;

	public TmtsFrameLayout(Instrumentation inst, FrameLayout frameLayout) {
		super(inst, frameLayout);
		this.frameLayout = frameLayout;
	}
}
