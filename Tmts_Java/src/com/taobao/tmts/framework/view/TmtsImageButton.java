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
