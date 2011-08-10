package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.util.Log;
import android.widget.CheckBox;

/**
 * Taobao Android Test Framework Class for {@link CheckBox}.
 * @author bingyang.djj
 * Added in 2011-05-20
 */
public class TmtsCheckBox extends TmtsButton {
	private static final String LOG_TAG = "TmtsCheckBox";
	private CheckBox checkBox;
    
	/**
	 * Constructor of {@link TmtsScrollView}.
	 * @param inst {@link Instrumentation}.
	 * @param checkBox {@link CheckBox}.
	 */
	public TmtsCheckBox(Instrumentation inst, CheckBox checkBox) {
		super(inst, checkBox);
		this.checkBox = checkBox;
	}
	
	/**
	 * Check the checkbox
	 */
	public void check() {
		inst.runOnMainSync(new Runnable(){
			
			@Override
			public void run(){
				Log.i(LOG_TAG, "Check the checkbox");
				checkBox.setChecked(true);
			}
		});
	}
	
	/**
	 * Uncheck the checkbox
	 */
	public void unCheck() {
		inst.runOnMainSync(new Runnable(){
			
			@Override
			public void run(){
				Log.i(LOG_TAG, "unCheck the checkbox");
				checkBox.setChecked(false);
			}
		});
	}
	
	/**
	 * return the state of checkbox
	 * @return Whether the checkbox is checked, true for checked 
	 * and false for unchekced
	 */
	public boolean isChecked() {
		return checkBox.isChecked();
	}
}
