package com.taobao.tmts.framework.view;

import android.app.Instrumentation;
import android.widget.TextView;

import com.taobao.tmts.framework.Constants;

/**
 * Taobao Android Test Framework Class for {@link TextView}.
 * @author bingyang.djj
 * Added in 2011-05-19
 */
public class TmtsTextView extends TmtsView {
	private static final String LOG_TAG = "TmtsTextView";
    private TextView textView;
    
    /**
     * Constructor of {@link TmtsTextView}.
     * @param inst {@link Instrumentation}.
     * @param textView {@link TextView}.
     */
    public TmtsTextView(Instrumentation inst, TextView textView) {
    	super(inst, textView);
    	this.textView = textView;
    }
    
    /**
     * Get text of the current {@link TextView}.
     * @return Text of the current TextView.
     */
    public String getText() {
    	//wait for app to take action sometimes
    	try {
			Thread.sleep(Constants.ANR_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	return textView.getText().toString();
    }
    
    /**
     * Set the specified text to {@link TextView}.
     * @param text the text ready to set to TextView
     */
    public void setText(final String text) {
    	inst.runOnMainSync(new Runnable() {
			
			@Override
			public void run() {
				textView.setText(text);
			}
		});
    }
}
