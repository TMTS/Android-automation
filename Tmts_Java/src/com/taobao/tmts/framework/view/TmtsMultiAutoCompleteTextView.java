package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.MultiAutoCompleteTextView;

public class TmtsMultiAutoCompleteTextView extends TmtsAutoCompleteTextView {
	private static final String LOG_TAG = "TmtsMultiAutoCompleteTextView";
	private MultiAutoCompleteTextView multiAutoCompleteTextView;

	public TmtsMultiAutoCompleteTextView(Instrumentation inst,
			MultiAutoCompleteTextView multiAutoCompleteTextView) {
		super(inst, multiAutoCompleteTextView);
		this.multiAutoCompleteTextView = multiAutoCompleteTextView;
	}

}
