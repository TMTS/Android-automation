package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.CheckedTextView;

/**
 * Taobao Android Test Framework Class for {@link CheckedTextView}.
 * 
 * @author bingyang.djj Added in 2011-08-08
 */
public class TmtsCheckedTextView extends TmtsTextView {
	private static final String LOG_TAG = "TmtsCheckedTextView";
	private CheckedTextView checkedTextView;

	/**
	 * Constructor of {@link TmtsCheckedTextView}.
	 * 
	 * @param inst
	 *            {@link Instrumentation}.
	 * @param view
	 *            {@link CheckedTextView}.
	 */
	public TmtsCheckedTextView(Instrumentation inst,
			CheckedTextView checkedTextView) {
		super(inst, checkedTextView);
		this.checkedTextView = checkedTextView;
	}

	public boolean isChecked() {
		return checkedTextView.isChecked();
	}

	/**
	 * Changes the checked state of this text view.
	 * 
	 * @param checked
	 *            true to check the text, false to uncheck it.
	 */
	public void setChecked(final boolean checked) {
		inst.waitForIdleSync();
		inst.runOnMainSync(new Runnable() {

			@Override
			public void run() {
				checkedTextView.setChecked(checked);
			}
		});
	}

	/**
	 * Change the checked state of the view to the inverse of its current state.
	 */
	public void toggle() {
		inst.waitForIdleSync();
		inst.runOnMainSync(new Runnable() {

			@Override
			public void run() {
				checkedTextView.toggle();
			}
		});
	}

}
