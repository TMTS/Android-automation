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
import android.widget.RelativeLayout;

/**
 * Taobao Android Test Framework Class for {@link RelativeLayout}.
 * @author bingyang.djj
 * Added in 2011-05-30
 */
public class TmtsRelativeLayout extends TmtsViewGroup{
	private static final String LOG_TAG = "TmtsLinearLayout";
	private RelativeLayout relativeLayout;
    
	/**
	 * Constructor of {@link TmtsView}.
	 * @param inst {@link Instrumentation}.
	 * @param relativeLayout {@link RelativeLayout}.
	 */
	public TmtsRelativeLayout(Instrumentation inst, RelativeLayout relativeLayout) {
		super(inst, relativeLayout);
		this.relativeLayout = relativeLayout;
	}

//	@Override
//	public void click() {
//		inst.runOnMainSync(new Runnable() {
//			
//			@Override
//			public void run() {
//				relativeLayout.performClick();
//			}
//		});
//	}
	
//	/**
//	 * Perform click on the specified tab.
//	 * @param index Tab index, start from 0 to totalIndex - 1.
//	 * @param totalIndex All tab counts.
//	 */
//	@Override
//	public void clickOnTab(int index, int totalIndex) {
//		try {
//			Thread.sleep(Tmts.FIND_VIEW_TIME_OUT);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		int[] xy = new int[2];
//		if (null == relativeLayout) {
//			Log.e(LOG_TAG, "View is null, clickOnTab() will fail");
//		}
//		relativeLayout.getLocationOnScreen(xy);
//		final int viewWidth = relativeLayout.getWidth();
//		final int viewHeight = relativeLayout.getHeight();
//		
//		final float x = xy[0] + (viewWidth / 2.0f) * ((2 * index + 1) / totalIndex);
//		float y = xy[1] + (viewHeight / 2.0f);
//		super.clickOnScreen(x, y);
//	}
}
