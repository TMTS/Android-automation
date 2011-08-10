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
