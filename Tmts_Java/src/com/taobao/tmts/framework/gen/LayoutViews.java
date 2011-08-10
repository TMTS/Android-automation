package com.taobao.tmts.framework.gen;

import com.taobao.tmts.framework.TmtsTestCase;

/**
 * Base Class for Auto Gen SubViews.
 * @author bingyang.djj
 * Added in 2011-06-21
 */
public class LayoutViews {
	protected TmtsTestCase context;
	
	/**
	 * Initialize this class.
	 * @param context Instance of TmtsTestCase
	 */
	public void setContext(TmtsTestCase context) {
		this.context = context;
	}
}
