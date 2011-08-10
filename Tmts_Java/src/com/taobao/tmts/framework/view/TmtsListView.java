package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.taobao.tmts.framework.Constants;
import com.taobao.tmts.framework.TmtsLog;

/**
 * Taobao Android Test Framework Class for {@link ListView}.
 * 
 * @author bingyang.djj Added in 2011-05-23
 */
public class TmtsListView extends TmtsAbsListView {
	private static final String LOG_TAG = "TmtsListView";
	private ListView listView;

	/**
	 * Constructor of {@link TmtsListView}.
	 * 
	 * @param inst
	 *            {@link Instrumentation}.
	 * @param listView
	 *            {@link ListView}.
	 */
	public TmtsListView(Instrumentation inst, ListView listView) {
		super(inst, listView);
		this.listView = listView;
	}

	/**
	 * Get listview's child view by index
	 * 
	 * @param index
	 *            The position of the child view
	 * @return Child view specified by the index, will be null if the index is
	 *         illegal.
	 */
	@SuppressWarnings("deprecation")
	private View getViewByIndex(final int index) {
		inst.waitForIdleSync();
		final long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() < startTime
				+ Constants.FIND_VIEW_TIME_OUT) {
			if (listView.getChildAt(index) == null) {
				Log.i(LOG_TAG, "getViewByIndex(" + index
						+ ") return null, sleep");

				try {
					Thread.sleep(Constants.RETRY_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else {
				Log.i(LOG_TAG, "getViewByIndex(" + index + ") succeed");
				return listView.getChildAt(index);
			}
		}
		TmtsLog.e(LOG_TAG, "getViewByIndex(" + index
				+ ") failed, time out after " + Constants.FIND_VIEW_TIME_OUT
				/ 1000 + " seconds, return null");
		return null;
	}

	/**
	 * Get listview's child view by index and return as a TmtsView. If the line
	 * is invisable, scroll to it first and the first line is what you want
	 * 
	 * @param index
	 *            The position of the child view
	 * @return Child view in TmtsView format specified by the index, will be
	 *         null if the index is illegal
	 */
	public TmtsView getTmtsViewByIndex(int index) {
		return new TmtsView(inst, getViewByIndex(index));
	}

	/**
	 * @deprecated Returns the currently checked item. The result is only valid
	 *             if the choice mode has been set to CHOICE_MODE_SINGLE.
	 * @return The position of the currently checked item or INVALID_POSITION if
	 *         nothing is selected
	 */
	public int getCheckedItemPosition() {
		return listView.getCheckedItemPosition();
	}

	/**
	 * Scroll the list to a given line
	 * 
	 * @param line
	 *            the line to scroll to
	 */
	public void scrollListToLine(final int line) {
		try {
			Thread.sleep(Constants.FIND_VIEW_TIME_OUT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		final int max = listView.getAdapter().getCount() - 1;
		
		inst.runOnMainSync(new Runnable() {

			@Override
			public void run() {
				
				if (line > max) {
					Log.i(LOG_TAG, "line > max, scrollListToLine(" + max + ")");
					listView.setSelection(max);
					
				} else {
					Log.i(LOG_TAG, "scrollListToLine(" + line + ")");
					listView.setSelection(line);
				}
			}
		});
	}

	/**
	 * Perform click on list item by the given text.
	 * 
	 * @param text
	 *            Text of the list item.
	 * @throws InterruptedException
	 */
	public void clickItemByText(String text) throws InterruptedException {
		clickUtils.clickOnText(text, false, 1, true, 0);
	}

	/**
	 * Smoothly scroll to the specified adapter
	 *             position. The view will scroll such that the indicated
	 *             position is displayed.
	 * @param position
	 *            Scroll to this adapter position
	 */
	public void smoothScrollToPosition(final int position) {
		try {
			Thread.sleep(Constants.FIND_VIEW_TIME_OUT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		final int max = listView.getAdapter().getCount() - 1;
		
		inst.runOnMainSync(new Runnable() {

			@Override
			public void run() {
				if (position > max) {
					Log.i(LOG_TAG, "position > max, smoothScrollToPosition(" + max + ")");
					listView.smoothScrollToPosition(max);
					
				} else {
					Log.i(LOG_TAG, "smoothScrollToPosition(" + position + ")");
					listView.smoothScrollToPosition(position);
				}
			}
		});
	}
	
	public int getSelcetedItemPosition() {
		try {
			Thread.sleep(Constants.ANR_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return listView.getSelectedItemPosition();
	}
}
