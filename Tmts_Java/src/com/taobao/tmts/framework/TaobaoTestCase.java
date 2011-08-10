package com.taobao.tmts.framework;

/**
 * Extends this class to build test clsss if you want to test taobao android client only.
 * @author bingyang.djj
 *
 */
public class TaobaoTestCase extends TmtsTestCase {
	private static final String LOG_TAG = "TaobaoTestCase";

	public TaobaoTestCase() throws Exception {
		super("com.taobao.taobao", "com.taobao.tao.Welcome");
	}
	
	/**
	 * Perform login. Call this method only after enter login interface.
	 * @param userName Username.
	 * @param passWord Password.
	 * @throws Exception Exception.
	 */
	public void login(String userName, String passWord) throws Exception {
		getTmtsAutoCompleteTextView("edit_username").setText(userName);
		getTmtsEditText("edit_password").setText(passWord);
		getTmtsCheckBox("Check").unCheck();
		getTmtsImageButton("login").doClick();
		Thread.sleep(Constants.ANR_TIME);
	}
	
	private void search(String searchKey) throws Exception {
		getTmtsEditText("searchedit").setText(searchKey);
		getTmtsImageButton("searchbtn").doClick();
		Thread.sleep(Constants.ANR_TIME);
	}
	
	/**
	 * Search goods by the given key word.
	 * @param searchKey Key word to search.
	 * @throws Exception Exception.
	 */
	public void searchGoods(String searchKey) throws Exception {
		search(searchKey);
		Thread.sleep(Constants.ANR_TIME);
	}
	
	/**
	 * Search shops by the given key word.
	 * @param searchKey Key word to search.
	 * @throws Exception Exception.
	 */
	public void searchShops(String searchKey) throws Exception {
		getTmtsImageButton("searchchoice").doClick();
		getTmtsButton("shop_btn").doClick();
		search(searchKey);
		Thread.sleep(Constants.ANR_TIME);
	}
	
}
