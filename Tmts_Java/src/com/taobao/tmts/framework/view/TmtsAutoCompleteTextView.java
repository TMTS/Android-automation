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
import android.widget.Adapter;
import android.widget.AutoCompleteTextView;

import com.taobao.tmts.framework.Constants;

/**
 * Taobao Android Test Framework Class for {@link AutoCompleteTextView}.
 * @author bingyang.djj
 * Added in 2011-05-23
 */
public class TmtsAutoCompleteTextView extends TmtsEditText {
	
	/**
	 * Log tag.
	 */
	private static final String LOG_TAG = "TmtsAutoCompleteTextView";
	private AutoCompleteTextView autoCompleteTextView;
    
	/**
	 * Constructor of {@link TmtsAutoCompleteTextView}.
	 * @param inst {@link Instrumentation}.
	 * @param autoCompleteTextView {@link AutoCompleteTextView}.
	 */
	public TmtsAutoCompleteTextView(Instrumentation inst, AutoCompleteTextView autoCompleteTextView) {
		super(inst, autoCompleteTextView);
		this.autoCompleteTextView = autoCompleteTextView;
	}
    
	/**
	 * Get the text of AutoCompleteTextView by the given index
	 * @param index index we specified
	 * @return text of the given index
	 */
	public String getAutoCompleteText(int index) {
		Adapter adapter = autoCompleteTextView.getAdapter();
		int maxIndex = adapter.getCount();
		
		if (index < 0 || index > maxIndex - 1) {
			return null;
			
		} else {
			try {
				Thread.sleep(Constants.ANR_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return adapter.getItem(index).toString();
		}
	}
	
//	/**
//	 * Sets the string value of the AutoCompleteTextView TextView
//	 * @param Text the string value to set
//	 */
//	public void setText(final String text) {
//		inst.runOnMainSync(new Runnable(){
//			
//			@Override
//			public void run(){
//				autoCompleteTextView.setText(text);
//			}
//		});
//	}
//	
//	/**
//	 * Return the text of the AutoCompleteTextView
//	 * @return The text of the AutoCompleteTextView
//	 */
//	public String getText() {
//		try {
//			Thread.sleep(Constants.ANR_TIME);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return autoCompleteTextView.getText().toString();
//	}
}
