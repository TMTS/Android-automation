package com.taobao.tmts.framework.gen;

import com.taobao.tmts.framework.TmtsTestCase;

/**
 * Base Class for Auto Gen Class from layout files
 * @author bingyang.djj
 * 
 */
public class TmtsGenClass {
    protected TmtsTestCase context;
	
    /**
     * Initialize this class.
     * @param context Instance of TmtsTestCase
     */
	public void setContext(TmtsTestCase context) {
		this.context = context;
	}
}
