package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.Button;

/**
 * Taobao Android Test Framework Class for {@link Button}.
 * @author shidun
 * Added in 2011-05-16
 */
public class TmtsButton extends TmtsTextView {   
	private Button button;
	
	/**
	 * Constructor of {@link TmtsScrollView}.
	 * @param inst {@link android.app.Instrumentation}.
	 * @param button {@link android.widget.Button}.
	 */
	public TmtsButton(Instrumentation inst, Button button){
		super(inst, button);
		this.button = button;
	}
}
