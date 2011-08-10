package com.taobao.tmts.framework.utils;

import java.util.ArrayList;

import junit.framework.Assert;
import android.app.Instrumentation;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Some methods come from come from Solo Scroller.java.
 * @author bingyang.djj, original authors is Renas Reda, renas.reda@jayway.com.
 *
 */
public class ScrollUtils {
	
	private static final String LOG_TAG = "ScrollUtils";
	private Instrumentation inst;
	private ActivityUtils activityUtils;
	private ViewUtils viewUtils;
	private Sleeper sleeper;
	
	
	public static final int DOWN = 0;
	public static final int UP = 1;
	
	public ScrollUtils(Instrumentation inst, ActivityUtils activityUtils,
			ViewUtils viewUtils, Sleeper sleeper) {
		this.inst = inst;
		this.activityUtils = activityUtils;
		this.viewUtils = viewUtils;
		this.sleeper = sleeper;
	}
	
	/**
	 * Scrolls up and down.
	 * 
	 * @param direction the direction in which to scroll
	 * @return {@code true} if more scrolling can be done
	 * 
	 */
	public boolean scroll(int direction) {
		final ArrayList<View> viewList = viewUtils.getViews(null, true);
		final ArrayList<ListView> listViews = ViewUtils.filterViews(ListView.class, viewList);

		if (listViews.size() > 0) {
			return scrollList(ListView.class, 0, direction, listViews);
		} 
		
		final ArrayList<GridView> gridViews = ViewUtils.filterViews(GridView.class, viewList);

		if (gridViews.size() > 0) {
			return scrollList(GridView.class, 0, direction, gridViews);
		} 

		final ArrayList<ScrollView> scrollViews = ViewUtils.filterViews(ScrollView.class, viewList);

		if (scrollViews.size() > 0) {
			return scrollScrollView(direction, scrollViews);
		}
		return false;
	}
	
	/**
	 * Scrolls a list.
	 * 
	 * @param listIndex the list to be scrolled
	 * @param direction the direction to be scrolled
	 * @return {@code true} if more scrolling can be done
	 * 
	 */
	public <T extends AbsListView> boolean scrollList(Class<T> classToFilterBy, int listIndex, int direction, ArrayList<T> listViews) {
		final T listView = viewUtils.getView(classToFilterBy, listViews, listIndex);

		if(listView == null)
			Assert.assertTrue("No ListView with index " + listIndex + " is found!", false);

		if (direction == DOWN) {
			if (listView.getLastVisiblePosition() >= listView.getCount()-1) {
				scrollListToLine(listView, listView.getLastVisiblePosition());
				return false;
			}
			
			if(listView.getFirstVisiblePosition() != listView.getLastVisiblePosition())
				scrollListToLine(listView, listView.getLastVisiblePosition());
	
			else
				scrollListToLine(listView, listView.getFirstVisiblePosition()+1);

		} else if (direction == UP) {
			if (listView.getFirstVisiblePosition() < 2) {
				scrollListToLine(listView, 0);
				return false;
			}

			final int lines = listView.getLastVisiblePosition() - listView.getFirstVisiblePosition();
			int lineToScrollTo = listView.getFirstVisiblePosition() - lines;

			if(lineToScrollTo == listView.getLastVisiblePosition())
				lineToScrollTo--;
			
			if(lineToScrollTo < 0)
				lineToScrollTo = 0;

			scrollListToLine(listView, lineToScrollTo);
		}	
		sleeper.sleep();
		return true;
	}
	
	/**
	 * Scroll the list to a given line
	 * @param listView the listView to scroll
	 * @param line the line to scroll to
	 */
	private <T extends AbsListView> void scrollListToLine(final T view, final int line){
		
		final int lineToMoveTo;
		if(view instanceof GridView)
			lineToMoveTo = line+1;
		else
			lineToMoveTo = line;
	
		inst.runOnMainSync(new Runnable(){
			public void run(){
				view.setSelection(lineToMoveTo);
			}
		});
	}
	
	/**
	 * Scrolls a ScrollView.
	 * 
	 * @param direction the direction to be scrolled
	 * @return {@code true} if more scrolling can be done
	 * 
	 */
	private boolean scrollScrollView(int direction, ArrayList<ScrollView> scrollViews){
		final ScrollView scroll = viewUtils.getView(ScrollView.class, scrollViews, 0);
		int scrollAmount = 0;
		
		if(scroll != null){
			int height = scroll.getHeight();
			height--;
			int scrollTo = 0;

			if (direction == DOWN) {
				scrollTo = (height);
			}

			else if (direction == UP) {
				scrollTo = (-height);
			}
			scrollAmount = scroll.getScrollY();
			scrollScrollViewTo(scroll,0, scrollTo);
			if (scrollAmount == scroll.getScrollY()) {
				return false;
			}
			else{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Scroll the list to a given line
	 * @param listView the listView to scroll
	 * @param line the line to scroll to
	 */
	private void scrollScrollViewTo(final ScrollView scrollView, final int x, final int y){
		inst.runOnMainSync(new Runnable(){
			public void run(){
				scrollView.scrollBy(x, y);
			}
		});
	}
}
