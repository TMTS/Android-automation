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
package com.taobao.tmts.framework.utils;

import java.util.ArrayList;
import java.util.regex.Pattern;

import junit.framework.Assert;
import android.app.Activity;
import android.app.Instrumentation;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

/**
 * Some methods come from Solo Clicker.java.
 * 
 * @author bingyang.djj, original authors is Renas Reda, renas.reda@jayway.com.
 *
 */
public class ClickUtils {
	private static final String LOG_TAG = "ClickUtils";
	
	private Instrumentation inst;
	private ViewUtils viewUtils;
	private ActivityUtils activityUtils;
	private static Sleeper sleeper;
	private MatchCounter matchCounter;
	private ScrollUtils scrollUtils;
	
	public ClickUtils(Instrumentation inst, Activity activity) {
		this.inst = inst;
		this.sleeper = new Sleeper();
		this.matchCounter = new MatchCounter();
		this.activityUtils = new ActivityUtils(inst, activity, sleeper);
		this.viewUtils = new ViewUtils(inst, activityUtils, sleeper);
		this.scrollUtils = new ScrollUtils(inst, activityUtils, viewUtils, sleeper);
	}
	
	/**
	 * Click on a given view
	 * @throws InterruptedException 
	 */
	public static void clickOnScreen(Instrumentation instrumentation, View view, boolean longClick) throws InterruptedException {
//		if(view == null)
//			Assert.assertTrue("View is null and can therefore not be clicked!", false);
		int[] xy = new int[2];

		view.getLocationOnScreen(xy);

		final int viewWidth = view.getWidth();
		final int viewHeight = view.getHeight();
		final float x = xy[0] + (viewWidth / 2.0f);
		float y = xy[1] + (viewHeight / 2.0f);
		Log.i(LOG_TAG, "click on x: " + x + " y: "+ y);

		if (longClick) {
			clickLongOnScreen(instrumentation, x, y);
		} else {
			clickOnScreen(instrumentation, x, y);
		}
	}
	
	/**
	 * Clicks on a given coordinate on the screen
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 *
	 */
	public static void clickOnScreen(Instrumentation instrumentation, float x, float y) {
		long downTime = SystemClock.uptimeMillis();
		long eventTime = SystemClock.uptimeMillis();
		MotionEvent event = MotionEvent.obtain(downTime, eventTime,
				MotionEvent.ACTION_DOWN, x, y, 0);
		MotionEvent event2 = MotionEvent.obtain(downTime, eventTime,
				MotionEvent.ACTION_UP, x, y, 0);
		
		try{
			instrumentation.sendPointerSync(event);
			instrumentation.sendPointerSync(event2);
			Log.i(LOG_TAG, "sent motionevent to click, x is " + x + " y is " + y);
			
		}catch(SecurityException e){
			Assert.assertTrue("Click can not be completed!", false);
		}
	}
	
	/**
	 * Long clicks a given coordinate on the screen
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @throws InterruptedException 
	 *
	 */

	public static void clickLongOnScreen(Instrumentation instrumentation, float x, float y) throws InterruptedException {
		long downTime = SystemClock.uptimeMillis();
		long eventTime = SystemClock.uptimeMillis();
		MotionEvent event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, x, y, 0);
		try{
			instrumentation.sendPointerSync(event);
		}catch(SecurityException e){
			Assert.assertTrue("Click can not be completed! Something is in the way e.g. the keyboard.", false);
		}
		instrumentation.waitForIdleSync();
		eventTime = SystemClock.uptimeMillis();
		event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_MOVE, 
				x + ViewConfiguration.getTouchSlop() / 2,
				y + ViewConfiguration.getTouchSlop() / 2, 0);
		instrumentation.sendPointerSync(event);
		instrumentation.waitForIdleSync();
//		if(time > 0)
//			sleeper.sleep(time);
//		else
			Thread.sleep((int)(ViewConfiguration.getLongPressTimeout() * 1.5f));

		eventTime = SystemClock.uptimeMillis();
		event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, x, y, 0);
		instrumentation.sendPointerSync(event);
		instrumentation.waitForIdleSync();
//		sleeper.sleep();

	}
	
	/**
	 * Clicks on a specific {@link TextView} displaying a given text.
	 *
	 * @param regex the text that should be clicked on. The parameter <strong>will</strong> be interpreted as a regular expression.
	 * @param longClick {@code true} if the click should be a long click
	 * @param match the regex match that should be clicked on
	 * @param scroll whether to scroll to find the regex
	 * @param time the amount of time to long click
	 * @throws InterruptedException 
	 */
	public void clickOnText(String regex, boolean longClick, int match, boolean scroll, int time) throws InterruptedException {
		final Pattern pattern = Pattern.compile(regex);
//		waiter.waitForText(regex, 0, TIMEOUT, scroll, true);
		TextView textToClick = null;
		ArrayList <TextView> textViewList = viewUtils.getCurrentViews(TextView.class);
		textViewList = ViewUtils.removeInvisibleViews(textViewList);
		if (match == 0) {
			match = 1;
		}
		for (TextView textView : textViewList){
			if(pattern.matcher(textView.getText().toString()).find()){
				matchCounter.addMatchToCount();
			}
			if (matchCounter.getTotalCount() == match) {
				matchCounter.resetCount();
				textToClick = textView;
				break;
			}
		}
		if (textToClick != null) {
			clickOnScreen(this.inst, textToClick, longClick);
			
		} else if (scroll && scrollUtils.scroll(ScrollUtils.DOWN)) {
			clickOnText(regex, longClick, match, scroll, time);
		} else {
			if (matchCounter.getTotalCount() > 0)
				Assert.assertTrue("There are only " + matchCounter.getTotalCount() + " matches of " + regex, false);
			else {
				for (TextView textView : textViewList) {
					Log.d(LOG_TAG, regex + " not found. Have found: " + textView.getText());
				}
				Assert.assertTrue("The text: " + regex + " is not found!", false);
			}
			matchCounter.resetCount();
		}
	}
}
