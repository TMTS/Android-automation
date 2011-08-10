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
