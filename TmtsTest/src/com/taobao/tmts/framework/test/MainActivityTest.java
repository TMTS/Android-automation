package com.taobao.tmts.framework.test;

import com.taobao.tmts.framework.TmtsTestCase;
import com.taobao.tmts.framework.view.TmtsCheckBox;
import com.taobao.tmts.framework.view.TmtsTextView;
import com.taobao.tmts.framework.view.TmtsView;


public class MainActivityTest extends TmtsTestCase {
	private static final String LOG_TAG = "MainActivityTest";

	public MainActivityTest() throws Exception {
		super("com.taobao.tmts.framework.app", "com.taobao.tmts.framework.app.MainActivity");
	}
	
//	public void testGotoTextView() throws Exception {
//		getTmtsButton("btn_textview_activity").doClick();
//		Thread.sleep(3000);
//	}
	
	public void testCheckBox() throws Exception {
//		TmtsView include = getTmtsView("include_checkbox");
		TmtsView include = getTmtsView("include_checkbox", TmtsView.class);
		include.findTmtsViewById("my_checkbox", TmtsCheckBox.class).doClick();
		TmtsTextView tmtsTextView = include.findTmtsViewById("textview", TmtsTextView.class);
		assertEquals("CheckBox is checked!", tmtsTextView.getText());
	}
	
	public void testCheckBox1() throws Exception {
		getTmtsViewInTree("include_checkbox>my_checkbox", TmtsCheckBox.class).doClick();
		TmtsTextView tmtsTextView = getTmtsViewInTree("include_checkbox>textview", TmtsTextView.class);
		assertEquals("CheckBox is checked!", tmtsTextView.getText());
	}
}
