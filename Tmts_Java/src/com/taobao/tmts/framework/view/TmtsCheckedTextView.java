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
import android.widget.CheckedTextView;

/**
 * Taobao Android Test Framework Class for {@link CheckedTextView}.
 * 
 * @author bingyang.djj Added in 2011-08-08
 */
public class TmtsCheckedTextView extends TmtsTextView {
	private static final String LOG_TAG = "TmtsCheckedTextView";
	private CheckedTextView checkedTextView;

	/**
	 * Constructor of {@link TmtsCheckedTextView}.
	 * 
	 * @param inst
	 *            {@link Instrumentation}.
	 * @param view
	 *            {@link CheckedTextView}.
	 */
	public TmtsCheckedTextView(Instrumentation inst,
			CheckedTextView checkedTextView) {
		super(inst, checkedTextView);
		this.checkedTextView = checkedTextView;
	}

	public boolean isChecked() {
		return checkedTextView.isChecked();
	}

	/**
	 * Changes the checked state of this text view.
	 * 
	 * @param checked
	 *            true to check the text, false to uncheck it.
	 */
	public void setChecked(final boolean checked) {
		inst.waitForIdleSync();
		inst.runOnMainSync(new Runnable() {

			@Override
			public void run() {
				checkedTextView.setChecked(checked);
			}
		});
	}

	/**
	 * Change the checked state of the view to the inverse of its current state.
	 */
	public void toggle() {
		inst.waitForIdleSync();
		inst.runOnMainSync(new Runnable() {

			@Override
			public void run() {
				checkedTextView.toggle();
			}
		});
	}

}
