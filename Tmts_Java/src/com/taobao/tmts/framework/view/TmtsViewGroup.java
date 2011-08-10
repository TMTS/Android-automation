package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.view.ViewGroup;

public class TmtsViewGroup extends TmtsView {
	private static final String LOG_TAG = "TmtsViewGroup";
	private ViewGroup viewGroup;

	public TmtsViewGroup(Instrumentation inst, ViewGroup viewGroup) {
		super(inst, viewGroup);
		this.viewGroup = viewGroup;
	}

}
