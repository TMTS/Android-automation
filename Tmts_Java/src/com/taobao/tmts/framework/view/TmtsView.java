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

import java.lang.reflect.Constructor;

import android.app.Instrumentation;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.taobao.tmts.framework.Constants;
import com.taobao.tmts.framework.Tmts;
import com.taobao.tmts.framework.TmtsLog;
import com.taobao.tmts.framework.utils.ClickUtils;

/**
 * Taobao Android Test Framework Class for {@link View}.
 * 
 * @author shidun Added in 2011-05-16, last modified by bingyang in 2011-05-19
 */
public class TmtsView {
	private static final String LOG_TAG = "TmtsView";
	protected Instrumentation inst;
	private View view;

	protected ClickUtils clickUtils;

	/**
	 * Constructor of {@link TmtsView}.
	 * 
	 * @param inst
	 *            {@link Instrumentation}.
	 * @param view
	 *            {@link View}.
	 */
	public TmtsView(Instrumentation inst, View view) {
		this.inst = inst;
		this.view = view;
	}

	/**
	 * @deprecated Users should not call this method.
	 * @param clickUtils
	 */
	public void init(ClickUtils clickUtils) {
		this.clickUtils = clickUtils;
	}

	/**
	 * Get a handler associated with the thread running the View.
	 * 
	 * @return handler associated with the thread running the View. This handler
	 *         can be used to pump events in the UI events queue.
	 */
	public Handler getHandler() {
		return view.getHandler();
	}

	/**
	 * Returns this view's identifier.
	 * 
	 * @return a positive integer used to identify the view or NO_ID if the view
	 *         has no ID
	 */
	public int getViewId() {
		Log.i(LOG_TAG, "getViewId() is " + view.getId());
		return view.getId();
	}

	/**
	 * Perform click on this view By MontionEvent, use this method to perform
	 * click much more often than using click()
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("deprecation")
	public void doClick() throws InterruptedException {
		Log.i(LOG_TAG, "doClick()");

		// sometimes we need to wait for a view to be shown
		try {
			Thread.sleep(Constants.ANR_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (null == view) {
			TmtsLog.e(LOG_TAG, "View is null, doClick() failed");
		}

		ClickUtils.clickOnScreen(this.inst, this.view, false);
	}

	public void doLongClick() throws InterruptedException {
		Log.i(LOG_TAG, "doLongClick()");

		// sometimes we need to wait for a view to be shown
		try {
			Thread.sleep(Constants.ANR_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (null == view) {
			TmtsLog.e(LOG_TAG, "View is null, doLongClick() failed");
		}

		ClickUtils.clickOnScreen(this.inst, this.view, true);
	}

	/**
	 * Perform click on this view By api:performClick()
	 * 
	 * @deprecated Use doClick()
	 */
	public void click() {
		try {
			Thread.sleep(Constants.ANR_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		inst.runOnMainSync(new Runnable() {

			@Override
			public void run() {
				view.performClick();
			}
		});
	}

	/**
	 * Return the width of the your view.
	 * 
	 * @return The width of your view, in pixels.
	 */
	public int getViewWidth() {
		Log.i(LOG_TAG, "getViewWidth() is " + view.getWidth());
		return view.getWidth();
	}

	/**
	 * Return the height of your view.
	 * 
	 * @return The height of your view, in pixels.
	 */
	public int getViewHeight() {
		Log.i(LOG_TAG, "getViewWidth() is " + view.getHeight());
		return view.getHeight();
	}

	/**
	 * Perform click on the specified tab. Call this method to click muti-tabs.
	 * 
	 * @param index
	 *            Tab index, start from 0 to totalIndex - 1.
	 * @param totalIndex
	 *            All tab counts.
	 */
	public void clickOnTab(int index, int totalIndex) {
		try {
			Thread.sleep(Constants.FIND_VIEW_TIME_OUT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int[] xy = new int[2];
		if (null == view) {
			Log.e(LOG_TAG, "View is null, clickOnTab() will fail");
		}
		view.getLocationOnScreen(xy);
		final int viewWidth = view.getWidth();
		final int viewHeight = view.getHeight();

		final float x = xy[0] + (viewWidth / 2.0f)
				* ((2 * index + 1) / totalIndex);
		float y = xy[1] + (viewHeight / 2.0f);
		ClickUtils.clickOnScreen(this.inst, x, y);
	}
    
	/**
	 * 
	 * @param <T>
	 * @param name
	 * @param caster
	 * @return
	 * @throws Exception
	 */
	public <T extends View> T findViewById(String name, Class<T> caster) throws Exception {
		return caster.cast(view.findViewById(Tmts.getIdByName(name)));
	}

	/**
	 * 
	 * @param <T>
	 * @param name
	 * @param caster
	 * @return
	 * @throws Exception
	 */
	public <T extends TmtsView> T findTmtsViewById(String name, Class<T> caster) throws Exception {
		Constructor<?>[] constructors = caster.getDeclaredConstructors();
		Object obj = constructors[0].newInstance(inst, view.findViewById(Tmts.getIdByName(name)));
		return caster.cast(obj);
	}
	
	public void requestFocus() {
		inst.waitForIdleSync();
		inst.runOnMainSync(new Runnable() {
			
			@Override
			public void run() {
				view.requestFocus();
			}
		});
	}
}
