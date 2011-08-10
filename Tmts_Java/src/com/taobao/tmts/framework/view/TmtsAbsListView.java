package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.AbsListView;

public class TmtsAbsListView extends TmtsAdapterView {
	private static final String LOG_TAG = "TmtsAbsListView";
	private AbsListView absListView;

	public TmtsAbsListView(Instrumentation inst,
			AbsListView absListView) {
		super(inst, absListView);
		this.absListView = absListView;
	}

}
