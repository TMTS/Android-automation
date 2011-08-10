package com.taobao.tmts.framework.view;

import android.util.Log;

public class TmtsWebElement {
 private final TmtsWebView mTmtsWebView;
	
	public TmtsWebElement(TmtsWebView tmtsWebView){
		mTmtsWebView = tmtsWebView;
	}
	
	public TmtsWebElement nextSibling() {
		//TODO
		return this;
	}
	
	public String innerHTML(){
		return excuteJavaScriptAndReturn("element.innerHTML");	
	}
	
	public void click() {
		Log.d("TmtsActivity","click in webelement");
		loadJavascript("element.dispatchEvent(e)");
	}
	
	
	private String excuteJavaScriptAndReturn(String script) {
		loadJavascript("window.webdriver.excutejs("+script+")");
		return JavascriptInterface.getInstance().getResult();
	}
	
	public void excuteJs(final String script) throws InterruptedException {
		loadJavascript(script);
	}
	
	private void loadJavascript(String script) {
//		this.currentScript = script;
		mTmtsWebView.getInterface().setReady(false);
		mTmtsWebView.getWebView().loadUrl("javascript:"+ script);
	}
}
