package com.taobao.tmts.framework.test;

import com.taobao.tmts.framework.TmtsTestCase;
import com.taobao.tmts.framework.view.TmtsAutoCompleteTextView;
import com.taobao.tmts.framework.view.TmtsButton;
import com.taobao.tmts.framework.view.TmtsCheckedTextView;
import com.taobao.tmts.framework.view.TmtsEditText;
import com.taobao.tmts.framework.view.TmtsTextView;

public class TextViewActivityTest extends TmtsTestCase {
	
	private static final String LOG_TAG = "TextViewActivityTest";
    
	public TextViewActivityTest() throws Exception {
		super("com.taobao.tmts.framework.app", "com.taobao.tmts.framework.app.MainActivity");
	}
	
	
	public void testTextViewGetText() throws Exception {
		getTmtsButton("btn_textview_activity").doClick();
		String textString = getTmtsTextView("my_textview").getText();
		assertEquals("Hello world", textString);
	}
	
	public void testTextViewSetText() throws Exception {
		getTmtsButton("btn_textview_activity").doClick();
		TmtsTextView myTextView = getTmtsTextView("my_textview");
		myTextView.setText("This is the text set by user");
		assertEquals("This is the text set by user", myTextView.getText());
	}
	
	public void testEditeTextGetText() throws Exception {
		getTmtsButton("btn_textview_activity").doClick();
		TmtsEditText myEditText = getTmtsEditText("my_edittext");
		assertEquals("Hello world", myEditText.getText());
	}
	
	public void testAutocompleteTextViewGetText() throws Exception {
		getTmtsButton("btn_textview_activity").doClick();
		TmtsAutoCompleteTextView myAutoCompleteTextView = getTmtsAutoCompleteTextView("my_autocompletetextview");
		assertEquals("Hello world", myAutoCompleteTextView.getText());
	}
	
	public void testAutocompleteTextViewSetText() throws Exception {
		getTmtsButton("btn_textview_activity").doClick();
		TmtsAutoCompleteTextView myAutoCompleteTextView = getTmtsAutoCompleteTextView("my_autocompletetextview");
		myAutoCompleteTextView.setText("This is the text set by user");
		assertEquals("This is the text set by user", myAutoCompleteTextView.getText());
	}
	
	public void testCheckedTextViewCheck() throws Exception {
		getTmtsView("btn_textview_activity", TmtsButton.class).doClick();
		TmtsCheckedTextView myCheckedTextView = getTmtsView("my_checkedtextview", TmtsCheckedTextView.class);
		myCheckedTextView.doClick();
		assertEquals("Checked", myCheckedTextView.getText());
	}
	
	public void testCheckedTextViewToggle() throws Exception {
		getTmtsView("btn_textview_activity", TmtsButton.class).doClick();
		TmtsCheckedTextView myCheckedTextView = getTmtsView("my_checkedtextview", TmtsCheckedTextView.class);
		myCheckedTextView.toggle();
		assertEquals(true, myCheckedTextView.isChecked());
	}
}
