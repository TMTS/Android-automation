package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.ViewFlipper;

/**
 * Taobao Android Test Framework Class for {@link ViewFlipper}.
 * @author bingyang.djj
 * Added in 2011-06-03
 */
public class TmtsViewFlipper extends TmtsViewAnimator {
	private static final String LOG_TAG = "TmtsViewFlipper";
	private ViewFlipper viewFlipper;
    
	/**
	 * Constructor of {@link TmtsViewFlipper}.
	 * @param inst {@link Instrumentation}.
	 * @param viewFlipper {@link ViewFlipper}.
	 */
	public TmtsViewFlipper(Instrumentation inst, ViewFlipper viewFlipper) {
		super(inst, viewFlipper);
		this.viewFlipper = viewFlipper;
	}
    
	/**
	 * Sets which child view will be displayed.
	 * @param whichChild the index of the child view to display
	 */
	public void setChildView(final int whichChild) {
		inst.runOnMainSync(new Runnable() {
			
			@Override
			public void run() {
				viewFlipper.setDisplayedChild(whichChild);
			}
		});
	}
}
