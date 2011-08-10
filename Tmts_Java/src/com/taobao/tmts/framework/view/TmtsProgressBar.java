/* TMTS - Android automation testing Framework.
 Copyright (C) 2010-2011 TaoBao UI AutoMan Team

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., HuaXing road, Hangzhou,China. 
 Email:taichan@taobao.com,shidun@taobao.com,bingyang@taobao.com
*/
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
