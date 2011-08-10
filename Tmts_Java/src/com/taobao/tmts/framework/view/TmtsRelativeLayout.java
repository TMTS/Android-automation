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
