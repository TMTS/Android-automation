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
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Taobao Android Test Framework Class for TextView
 * 
 * @author shidun Added in 2011-05-31
 */
public class TmtsWebView {
	private final Instrumentation inst;
	private static final String LOG_TAG = "TmtsWebView";
	private final WebView webView;
	private final JavascriptInterface jInterface;

	/**
	 * Constructor of TmtsTextView
	 * @author shidun
	 * @param inst
	 *            Instrumentation
	 * @param textView
	 *            TextView
	 */
	public TmtsWebView(Instrumentation inst, WebView webview) {
		this.webView = webview;
		this.inst = inst;
		this.jInterface = JavascriptInterface.getInstance();
		this.jInterface.setTmtsWebView(this);
		initWebViewSettings(webView);
	}

	/**
	 * @author shidun
	 * @param script String
	 * @return String 通过执行javascript脚本，对webview页面进行各种操作：查找元素，点击等
	 * @throws InterruptedException 
	 */
	public String excuteJsAndReturn(final String script){
		Log.d("Mywebview", "progress:" + webView.getProgress());
		while (!waitForWebViewLoaded()) {
			waitForWebViewLoaded();
		}
		loadJavascript("window.webdriver.excutejs(" + script + ")");
		Log.i(LOG_TAG,script);
		return jInterface.getResult();
	}
	
	/**
	 * @author shidun
	 * @param script String
	 * @return String 通过执行javascript脚本，对webview页面进行各种操作：查找元素，点击等
	 * @throws InterruptedException 
	 */
	public void excuteJs(final String script) throws InterruptedException {
		Log.d("Mywebview", "progress:" + webView.getProgress());
		while (!waitForWebViewLoaded()) {
			waitForWebViewLoaded();
		}
		loadJavascript(script);
		Log.i(LOG_TAG,script);	
	}

	public TmtsWebElement getElementById(String id){
		loadJavascript("var element = document.getElementById('"+id+"');"); 	
		Log.i(LOG_TAG,jInterface.getResult());
		return new TmtsWebElement(this);
	}
	
	public TmtsWebElement getElementsByClassName(String className){
		loadJavascript("var element = document.getElementsByClassName('"+className+"')[0];"); 	
		Log.i(LOG_TAG,jInterface.getResult());
		return new TmtsWebElement(this);
	}
	
	/**
	 * @author shidun
	 * @return webview
	 */
	public WebView getWebView() {
		return webView;
	}

	/**
	 * @author shidun
	 * @return webview url
	 */
	public String getUrl() {
		return webView.getUrl();
	}

	/**
	 * @author shidun
	 * @return webview title
	 */
	public String getTitle() {
		return webView.getTitle();
	}
	public JavascriptInterface getInterface(){
		return this.jInterface;
	}

	/**
	 * @author shidun Wait for the html be loaded
	 * @return boolean
	 */
	private boolean waitForWebViewLoaded() {
		Boolean isOK = false;
		try {
			if (webView.getProgress() == 100) {
				isOK = true;
			} else {
				Thread.sleep(1000);
				isOK = false;
				Log.d("Mywebview", "sleep:" + webView.getProgress());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("Mywebview", "docReadyState:" + webView.getProgress());
		return isOK;
	}
	
	private void initWebViewSettings(WebView webView) {
		Log.d("Mywebview", "settings: " + webView);
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);			
		webView.addJavascriptInterface(jInterface, "webdriver");
		initJavascript();
	}
	
	final String initJavascript = "var e = document.createEvent('HTMLEvents');" +
    "e.initEvent('click', false, false);";				        	

	private void initJavascript() {
		loadJavascript(initJavascript);
	}
    
	private void loadJavascript(String script) {
		this.currentScript = script;
		jInterface.setReady(false);
		webView.loadUrl("javascript:"+ script);
	}
	private String currentScript ;

	public String getCurrentScript() {
		return currentScript;
	}
}
