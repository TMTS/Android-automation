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
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Taobao Android Test Framework Class for {@link ImageView}.
 * @author bingyang.djj
 * Added in 2011-05-23
 */
public class TmtsImageView extends TmtsView{
	private static final String LOG_TAG = "TmtsImageView";
	private ImageView imageView;
    
	/**
	 * Constructor of {@link TmtsImageView}.
	 * @param inst {@link Instrumentation}.
	 * @param imageView {@link ImageView}.
	 */
	public TmtsImageView(Instrumentation inst, ImageView imageView) {
		super(inst, imageView);
		this.imageView = imageView;
	}
	
	/**
	 * Gets the background drawable
	 * @return The drawable used as the background for this view, if any.
	 */
	public Drawable getBackground() {
		return imageView.getBackground();
	}
	
	/**
	 * Return the view's drawable, or null if no drawable has been assigned.
	 * @return The view's drawable
	 */
	public Drawable getDrawable() {
		return imageView.getDrawable();
	}
}
