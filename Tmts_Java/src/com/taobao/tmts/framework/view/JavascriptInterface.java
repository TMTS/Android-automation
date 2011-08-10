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

import android.util.Log;

/**
 * @author shidun Custom module that is added to the WebView's JavaScript engine
 *         to enable callbacks to java code. This is required since WebView
 *         doesn't expose the underlying DOM. 实现java和javascript之间的多线程异步通信机制。
 */
public final class JavascriptInterface {
	private volatile String result;
	private static volatile boolean resultReady;
	private static JavascriptInterface javascriptInterfaceInstance = new JavascriptInterface();
	private static long msecs = 1000;
	private static Integer count = 10;
	private TmtsWebView tmtsWebView;
	public void setTmtsWebView(TmtsWebView tmtsWebView) {
		this.tmtsWebView = tmtsWebView;
	}

	public JavascriptInterface() {
	}

	public static JavascriptInterface getInstance() {
		return javascriptInterfaceInstance;
	}

	/**
	 * @author shidun
	 * @return void 对页面执行的js执行回调，记录返回值。
	 */
	public void excutejs(String updated) {
			result = updated;
			setReady(true);
			Log.d("Tmts", "CallBack excutejs: " + result);
	}
	
	public synchronized void setReady(boolean isReady){
		resultReady = isReady;
	}

	
	/**
	 * @author shidun A callback from JavaScript to Java that passes execution
	 *         result as a parameter.
	 * 
	 *         This method is accessible from WebView's JS DOM as
	 *         windows.webdriver.getResult().
	 * 
	 * @param result
	 *            Result that should be returned to Java code from WebView.
	 */
	public String getResult(){
		String result="";
		 try{
			 result = getResult(count);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public String getResult(long retryTimes) throws Exception {
	 
		Log.d("Tmts", "retryTimes:" + retryTimes+"resultReady: "+resultReady+"tmtsWebView:"+tmtsWebView.getWebView());
		long startTime = System.currentTimeMillis();
		long waitTime = msecs;
		if (resultReady)
			return doGet(); 
		else {
			for (;;) {
				Thread.sleep(100);
				if (resultReady){
					Log.d("Tmts", "resultReady is: "+resultReady+" need doGet()");
					return doGet();
				}else {
					waitTime = msecs - (System.currentTimeMillis() - startTime);
					if (waitTime <= 0){
						if(retryTimes>0){
							if(tmtsWebView!=null){
								tmtsWebView.excuteJs(tmtsWebView.getCurrentScript());
								Log.d("Tmts", "retryTimes2:" + retryTimes--);
								return getResult(retryTimes);
							}else{
								return "webView is null";
							}
						}else{
							return "out of waittime";
						}
					}
				}
			}
		}
		
	}
	private String doGet(){
		setReady(false);
		return result;
	}
}