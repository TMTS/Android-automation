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
