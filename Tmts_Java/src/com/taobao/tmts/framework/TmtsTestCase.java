package com.taobao.tmts.framework;

import android.app.Activity;
import android.app.Dialog;
import android.app.Instrumentation;
import android.content.res.Resources;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.taobao.tmts.framework.gen.TmtsGenClass;
import com.taobao.tmts.framework.view.TmtsAutoCompleteTextView;
import com.taobao.tmts.framework.view.TmtsButton;
import com.taobao.tmts.framework.view.TmtsCheckBox;
import com.taobao.tmts.framework.view.TmtsCheckedTextView;
import com.taobao.tmts.framework.view.TmtsEditText;
import com.taobao.tmts.framework.view.TmtsImageButton;
import com.taobao.tmts.framework.view.TmtsImageView;
import com.taobao.tmts.framework.view.TmtsListView;
import com.taobao.tmts.framework.view.TmtsProgressBar;
import com.taobao.tmts.framework.view.TmtsRelativeLayout;
import com.taobao.tmts.framework.view.TmtsScrollView;
import com.taobao.tmts.framework.view.TmtsTextView;
import com.taobao.tmts.framework.view.TmtsView;
import com.taobao.tmts.framework.view.TmtsViewFlipper;
import com.taobao.tmts.framework.view.TmtsWebView;

/**
 * Extends this class to use TMTS£¬if you want to build class to test taobao
 * client only, use {@link TaobaoTestCase} instead.
 * 
 * @author bingyang.djj
 * 
 */
@SuppressWarnings("rawtypes")
public class TmtsTestCase extends ActivityInstrumentationTestCase2 {

	/**
	 * Log tag.
	 */
	private static final String LOG_TAG = "TmtsTestCase";

	/**
	 * Package name of the app under test.
	 */
	private String pkg;

	/**
	 * {@link Tmts}.
	 */
	private Tmts tmts;

	/**
	 * {@link Instrumentation}.
	 */
	private Instrumentation inst;
	
	/**
	 * Constructor of {@link TmtsTestCase}.
	 * 
	 * @param pkg
	 *            Package name of the app under test.
	 * @param activityClass
	 *            First {@link Activity} to start.
	 * @throws Exception
	 *             Exception.
	 */
	@SuppressWarnings("unchecked")
	public TmtsTestCase(String pkg, String activityClass) throws Exception {
		super(pkg, Class.forName(activityClass));
		this.pkg = pkg;
	}

	/**
	 * Return an instance of {@link Tmts}.
	 * 
	 * @return An instance of {@link Tmts}.
	 */
	private Tmts getTmts() {
		if (tmts == null) {
			tmts = new Tmts(getInstrumentation(), getActivity(), pkg);
		}
		return tmts;
	}

	@Override
	protected void runTest() {
		try {
			super.runTest();

		} catch (Throwable e) {
			TmtsLog.e(LOG_TAG, "", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Return a {@link Resources} instance for your application's package.
	 * 
	 * @return Resources instance for your application's package.
	 */
	public Resources getResources() {
		return tmts.getResources();
	}

	/**
	 * Returns the raw height of the display, in pixels.
	 * 
	 * @return the raw height of the display, in pixels
	 */
	public int getDisplayHeight() {
		return tmts.getHeight();
	}

	/**
	 * Returns the raw width of the display, in pixels.
	 * 
	 * @return the raw width of the display, in pixels.
	 */
	public int getDisplayWidth() {
		return tmts.getWidth();
	}
	
	/**
	 * 
	 * @param <T>
	 * @param idTree
	 * @param caster
	 * @return
	 * @throws Exception
	 */
	public <T extends TmtsView> T getTmtsViewInTree(String idTree, Class<T> caster) throws Exception {
		return tmts.getTmtsViewInTree(idTree, caster);
	}
    
	/**
	 * Return a {@link TmtsView} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsView} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsView getTmtsView(String name) throws Exception {
		return tmts.getTmtsView(name);
	}
	
	/**
	 * Return a {@link TmtsButton} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsButton} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsButton getTmtsButton(String name) throws Exception {
		return tmts.getTmtsButton(name);
	}

	/**
	 * Return a {@link TmtsTextView} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsTextView} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsTextView getTmtsTextView(String name) throws Exception {
		return tmts.getTmtsTextView(name);
	}

	/**
	 * Return a {@link TmtsCheckBox} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsCheckBox} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsCheckBox getTmtsCheckBox(String name) throws Exception {
		return tmts.getTmtsCheckBox(name);
	}

	/**
	 * Return a {@link TmtsEditText} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsEditText} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsEditText getTmtsEditText(String name) throws Exception {
		return tmts.getTmtsEditText(name);
	}

	/**
	 * Return a {@link TmtsImageView} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsImageView} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsImageView getTmtsImageView(String name) throws Exception {
		return tmts.getTmtsImageView(name);
	}

	/**
	 * Return a {@link TmtsImageButton} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsImageButton} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsImageButton getTmtsImageButton(String name) throws Exception {
		return tmts.getTmtsImageButton(name);
	}

	/**
	 * Return a {@link TmtsListView} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsListView} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsListView getTmtsListView(String name) throws Exception {
		return tmts.getTmtsListView(name);
	}

	/**
	 * Return a {@link TmtsScrollView} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsScrollView} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsScrollView getTmtsScrollView(String name) throws Exception {
		return tmts.getTmtsScrollView(name);
	}

	/**
	 * Return a {@link TmtsAutoCompleteTextView} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsAutoCompleteTextView} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsAutoCompleteTextView getTmtsAutoCompleteTextView(String name)
			throws Exception {
		return tmts.getTmtsAutoCompleteTextView(name);
	}

	/**
	 * Return a {@link TmtsWebView} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsWebView} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsWebView getTmtsWebView(String name) throws Exception {
		return tmts.getTmtsWebView(name);
	}

	/**
	 * Return a {@link TmtsRelativeLayout} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsRelativeLayout} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsRelativeLayout getTmtsRelativeLayout(String name)
			throws Exception {
		return tmts.getTmtsRelativeLayout(name);
	}

	/**
	 * Return a {@link TmtsViewFlipper} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsViewFlipper} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsViewFlipper getTmtsViewFlipper(String name) throws Exception {
		return tmts.getTmtsViewFlipper(name);
	}
	
	public TmtsCheckedTextView getTmtsCheckedTextView(String name) throws Exception {
		return tmts.getTmtsCheckedTextView(name);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param name
	 * @param caster
	 * @return
	 * @throws Exception
	 */
	public <T extends TmtsView> T getTmtsView(String name, Class<T> caster) throws Exception {
		return tmts.getTmtsView(name, caster);
	}

	/**
	 * Return a {@link TmtsButton} with the given text content, use this method
	 * to find a button belongs to a {@link Dialog}.
	 * 
	 * @param text
	 *            Content text of the button.
	 * @return {@link TmtsButton} with the given text content
	 */
	public TmtsButton findTmtsButton(String text) throws InterruptedException {
		return tmts.findTmtsButton(text);
	}

	/**
	 * Return a {@link TmtsProgressBar} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link TmtsProgressBar} with the given name.
	 * @throws Exception
	 *             Exception
	 */
	public TmtsProgressBar getTmtsProgressBar(String name) throws Exception {
		return tmts.getTmtsProgressBar(name);
	}

	/**
	 * Click on {@link View} by the given text.
	 * Use this method to click meun or listview.
	 * 
	 * @param text
	 *            Text of the view.
	 * @throws InterruptedException 
	 */
	public void clickOnViewByText(String text) throws InterruptedException {
		tmts.clickOnViewByText(text);
	}
	
	/**
	 * Click a button on dialog by text,
	 * 
	 * @param buttonText
	 *            Text of the button,
	 * @throws InterruptedException
	 *             InterruptedException,
	 */
	public void clickDialogButton(String buttonText)
			throws InterruptedException {
		tmts.clickDialogButton(buttonText);
	}

	@Override
	public void sendKeys(int... keys) {
		inst.waitForIdleSync();
		for (int i = 0; i < keys.length; i++) {
			inst.sendCharacterSync(keys[i]);
		}
	}

	/**
	 * Return an instance of a class created by xsl tool from layout files
	 * 
	 * @param <T>
	 *            Subclass of TmtsGenClass
	 * @param t
	 *            Class created by xsl tool from layout files
	 * @return A instance of a class created by xsl tool from layout files
	 */
	public <T extends TmtsGenClass> T Layout(Class<T> t) {
		try {
			T result = t.newInstance();
			result.setContext(this);
			return result;

		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Scrolls up.
	 * 
	 * @return {@code true} if more scrolling can be done.
	 * 
	 */
	public boolean scrollUp() {
		return tmts.scrollUp();
	}
	
	/**
	 * Scroll down.
	 * @return {@code true} if more scrolling can be done.
	 */
	public boolean scrollDown() {
		return tmts.scrollDown();
	}
	
	
	/**
	 * Perform full scroll to top.
	 */
	public void fullScrollUp() {
		tmts.fullScrollUp();
	}
	
	/**
	 * Perform full scroll to bottom.
	 */
	public void fullScrollDown() {
		tmts.scrollDown();
	}
	
	/**
	 * Scrolls down a list.
	 * @return true if more scrolling can be down.
	 */
	public boolean scrollListDown() {
		return tmts.scrollListDown();
	}
	
	/**
	 * Scrolls up a list.
	 * @return true if more scrolling can be down.
	 */
	public boolean scrollListUp() {
		return tmts.scrollListUp();
	}
	
	/**
	 * Scrolls a list to bottom.
	 */
	public void scrollListBottom() {
		tmts.scrollListBottom();
	}
	
	/**
	 * Scrolls a list to top.
	 */
	public void scrollListTop() {
		tmts.scrollListTop();
	}
	
	/**
	 * @deprecated This method does not work anyway.
	 * @param xStart
	 * @param yStart
	 * @param xEnd
	 * @param yEnd
	 */
	public void scrollScreen(float xStart, float yStart, float xEnd, float yEnd) {
		Log.i(LOG_TAG, "scrollScreen");
		MotionEvent e = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, xStart,
				yStart, 0);
		inst.sendPointerSync(e);

		e = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_MOVE, xStart,
				yStart, 0);
		inst.sendPointerSync(e);

		e = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_MOVE, xStart,
				yStart, 0);
		inst.sendPointerSync(e);

		e = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_MOVE, xEnd,
				yEnd, 0);
		inst.sendPointerSync(e);

		e = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_MOVE, xEnd,
				yEnd, 0);
		inst.sendPointerSync(e);

		e = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, xEnd, yEnd,
				0);
		inst.sendPointerSync(e);
		Log.i(LOG_TAG, "scrollScreen finish");
	}
    
	@Override
	protected void setUp() throws Exception {
		Log.i(LOG_TAG, "setUp()");
		super.setUp();
		this.inst = getInstrumentation();
		this.tmts = getTmts();
		Log.i(LOG_TAG, "setUp() finished");
	}

	@Override
	protected void tearDown() throws Exception {
		Log.i(LOG_TAG, "tearDown()");
		
		try {
			tmts.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		super.tearDown();
		Log.i(LOG_TAG, "tearDown() finished");
	}
}
