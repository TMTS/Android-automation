package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.EditText;

/**
 * Taobao Android Test Framework Class for {@link EditText}.
 * @author bingyang.djj
 * Added in 2011-05-20
 */
public class TmtsEditText extends TmtsTextView {
	private static final String LOG_TAG = "TmtsEditText";
    private EditText editText;
    
    /**
     * Constructor of {@link TmtsEditText}.
     * @param inst {@link Instrumentation}.
     * @param editText {@link EditText}.
     */
	public TmtsEditText(Instrumentation inst, EditText editText) {
		super(inst, editText);
		this.editText = editText;
	}
	
//	/**
//	 * Return the text the EditText is displaying
//	 * @return the text the EditText is displaying
//	 */
//	public String getText() {
//		try {
//			Thread.sleep(Constants.ANR_TIME);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return editText.getText().toString();
//	}
//	
//	/**
//	 * Sets the string value of the EditText
//	 * @param text the String to set to EditText
//	 */
//	public void setText(final String text) {
//		inst.runOnMainSync(new Runnable() {
//			
//			@Override
//			public void run() {
//				editText.setText(text);
//			}
//		});
//	}
}
