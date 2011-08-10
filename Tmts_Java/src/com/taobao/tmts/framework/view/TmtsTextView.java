/* TMTS - Android automation testing Framework.
 Copyright (C) 2010-2011 TaoBao UI AutoMan Team

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., HuaXing road, Hangzhou,China. 
 Email:taichan@taobao.com,shidun@taobao.com,bingyang@taobao.com
*/
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
