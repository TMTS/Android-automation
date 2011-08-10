//package com.taobao.tmts.framework.test;
//
//import android.util.Log;
//
//import com.taobao.tmts.framework.TmtsTestCase;
//import com.taobao.tmts.framework.view.TmtsWebView;
//
//public class WebViewTest extends TmtsTestCase {
//	private static final String TARGET_PACKAGE = "com.taobao.tmts.framework.app";
//	private static final String LOG_TAG = "Mywebview";
//	
//	public WebViewTest()  throws Exception {
//		super(TARGET_PACKAGE, "com.taobao.tmts.framework.app.FirstActivity");
//	}
//	
//	public void testclick() throws Exception  {		
//		findTmtsButton("goto webview").doClick();
//		TmtsWebView tmtsWebView = getTmtsWebView("mywebview");
//		String innerHTMlString = tmtsWebView.getElementById("link1").innerHTML();
//		Log.d(LOG_TAG,innerHTMlString);
//        tmtsWebView.getElementById("link1").click();
//        String innerHTML = tmtsWebView.document().innerHTML();
//        Log.d(LOG_TAG,innerHTML);
//		assertTrue(innerHTML.contains("Links2-Pass"));
//  }
//	public void testinnerHTML() throws Exception  {
//		findTmtsButton("goto webview").doClick();
//		TmtsWebView tmtsWebView = getTmtsWebView("mywebview");
//		String innerHTMlString = tmtsWebView.getElementById("link1").innerHTML();
//		Log.d(LOG_TAG,innerHTMlString);
//		assertTrue(innerHTMlString.contains("test1"));
//	}
//	
//}
