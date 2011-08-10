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
import android.widget.ImageButton;

/**
 * Taobao Android Test Framework Class for {@link ImageButton}.
 * @author bingyang.djj
 * Added in 2011-05-23
 */
public class TmtsImageButton extends TmtsImageView{
	private static final String LOG_TAG = "TmtsImageButton";
	private ImageButton imageButton;
    
	/**
	 * Constructor of {@link TmtsImageButton}.
	 * @param inst {@link Instrumentation}.
	 * @param imageButton {@link ImageButton}.
	 */
	public TmtsImageButton(Instrumentation inst, ImageButton imageButton) {
		super(inst, imageButton);
		this.imageButton = imageButton;
	}
}
