package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.ProgressBar;

/**
 * Taobao Android Test Framework Class for ProgressBar
 * @author bingyang.djj
 * Added in 2011-05-25
 */
public class TmtsProgressBar extends TmtsView {
	private static final String LOG_TAG = "TmtsProgressBar";
	private ProgressBar progressBar;
    
	/**
	 * Constructor of {@link TmtsScrollView}.
	 * @param inst {@link Instrumentation}.
	 * @param progressBar {@link ProgressBar}
	 */
	public TmtsProgressBar(Instrumentation inst, ProgressBar progressBar) {
		super(inst, progressBar);
		this.progressBar = progressBar;
	}
	
	/**
	 * Set the current progress to the specified value.
	 * @param progress the new progress, between 0 and getMax()
	 */
	public void setProgress(final int progress) {
		inst.runOnMainSync(new Runnable() {
			
			@Override
			public void run() {
				progressBar.setProgress(progress);
			}
		});
	}
	
	/**
	 * Get the progress bar's current level of progress. Return 0 when the progress bar is in indeterminate mode.
	 * @return the current progress, between 0 and getMax()
	 */
	public int getProgress() {
		return progressBar.getProgress();
	}
}
