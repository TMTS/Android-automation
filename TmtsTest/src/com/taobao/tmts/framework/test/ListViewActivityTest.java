package com.taobao.tmts.framework.test;

import com.taobao.tmts.framework.TmtsTestCase;
import com.taobao.tmts.framework.view.TmtsButton;
import com.taobao.tmts.framework.view.TmtsListView;
import com.taobao.tmts.framework.view.TmtsTextView;
import com.taobao.tmts.framework.view.TmtsView;

public class ListViewActivityTest extends TmtsTestCase {

	public ListViewActivityTest()
			throws Exception {
		super("com.taobao.tmts.framework.app", "com.taobao.tmts.framework.app.MainActivity");
	}
	
	public void testGetTmtsViewByIndex() throws Exception {
		getTmtsButton("btn_listview_activity").doClick();
		TmtsListView tmtsListView = getTmtsView("my_listview", TmtsListView.class);
		TmtsView tmtsView = tmtsListView.getTmtsViewByIndex(3);
		TmtsTextView tmtsTextView = tmtsView.findTmtsViewById("ItemTitle", TmtsTextView.class);
		assertEquals("Item3", tmtsTextView.getText());
	}
	
	public void testScrollListToLine() throws Exception {
		getTmtsView("btn_listview_activity", TmtsButton.class).doClick();
		TmtsListView tmtsListView = getTmtsListView("my_listview");
		tmtsListView.scrollListToLine(200);
		assertEquals(99, tmtsListView.getSelcetedItemPosition());
	}
	
	public void testSmoothScrollToPosition() throws Exception {
		getTmtsView("btn_listview_activity", TmtsButton.class).doClick();
		TmtsListView tmtsListView = getTmtsListView("my_listview");
		tmtsListView.smoothScrollToPosition(200);
		assertEquals(99, tmtsListView.getSelcetedItemPosition());
	}

}
