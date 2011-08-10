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
