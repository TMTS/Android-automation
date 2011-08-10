package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.ScrollView;

/**
 * Taobao Android Test Framework Class for {@link ScrollView}.
 * @author bingyang.djj
 * Added in 2011-05-24
 */
public class TmtsScrollView extends TmtsFrameLayout{
	private static final String LOG_TAG = "TmtsScrollView";
	private ScrollView scrollView;
    
	/**
	 * Constructor of {@link TmtsScrollView}.
	 * @param inst {@link Instrumentation}.
	 * @param scrollView {@link ScrollView}.
	 */
	public TmtsScrollView(Instrumentation inst, ScrollView scrollView) {
		super(inst, scrollView);
		this.scrollView = scrollView;
	}
	
	/**
	 * Set the scrolled position of your view.
	 * @param x the x position to scroll to
	 * @param y the y position to scroll to
	 */
	public void scrollTo(final int x, final int y) {
		inst.runOnMainSync(new Runnable() {
			
			@Override
			public void run() {
				scrollView.scrollTo(x, y);
			}
		});
	}
	
	/**
	 * Move the scrolled position of your view.
	 * @param x the amount of pixels to scroll by horizontally
	 * @param y the amount of pixels to scroll by horizontally
	 */
	public void scrollBy(final int x, final int y) {
		inst.runOnMainSync(new Runnable() {
			
			@Override
			public void run() {
				scrollView.scrollBy(x, y);
			}
		});
	}
	
	/**
	 * Handles scrolling in response to a "home/end" shortcut press. 
	 * This method will scroll the view to the top or bottom and give the focus to the topmost/bottommost component in the new visible area. 
	 * If no component is a good candidate for focus, this scrollview reclaims the focus.
	 * @param direction the scroll direction: android.view.View.FOCUS_UP to go the top of the view or 
	 * android.view.View.FOCUS_DOWN to go the bottom
	 */
	public void fullScroll(final int direction) {
		inst.runOnMainSync(new Runnable() {
			
			@Override
			public void run() {
				scrollView.fullScroll(direction);
			}
		});
	}
}
