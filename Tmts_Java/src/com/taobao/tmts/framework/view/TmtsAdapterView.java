package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.Adapter;
import android.widget.AdapterView;

public class TmtsAdapterView extends TmtsViewGroup {
	private static final String LOG_TAG = "TmtsAdapterView";
	private AdapterView<? extends Adapter> adapterView;

	public TmtsAdapterView(Instrumentation inst, AdapterView<? extends Adapter> adapterView) {
		super(inst, adapterView);
		this.adapterView = adapterView;
	}

}
