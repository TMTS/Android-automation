package com.taobao.tmts.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.taobao.tmts.framework.utils.ActivityUtils;
import com.taobao.tmts.framework.utils.ClickUtils;
import com.taobao.tmts.framework.utils.ScrollUtils;
import com.taobao.tmts.framework.utils.Sleeper;
import com.taobao.tmts.framework.utils.ViewUtils;
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
 * Taobao Android Test Framework Class for Activity.
 * 
 * @author shidun Added in 2011-05-16.
 * @author bingyang.djj.
 */
public class Tmts {

	/**
	 * Log tag.
	 */
	private static final String LOG_TAG = "Tmts";

	/**
	 * Package name of the app under test.
	 */
	private static String targetPkg;

	/**
	 * Parameter of Tmts.
	 */
	private final Instrumentation inst;

	/**
	 * Parameter of Tmts.
	 */
	private final Activity activity;

	private TmtsWebView currentView;
	private ActivityUtils activityUtils;
	private Sleeper sleeper;
	private ViewUtils viewUtils;
	private ClickUtils clickUtils;
	private ScrollUtils scrollUtils;

	/**
	 * Constructor of {@link Tmts}.
	 * 
	 * @param inst
	 *            {@link Instrumentation}.
	 * @param activity
	 *            {@link Activity}.
	 */
	public Tmts(Instrumentation inst, Activity activity) {
		this.activity = activity;
		this.inst = inst;
		this.sleeper = new Sleeper();
		this.activityUtils = new ActivityUtils(this.inst, this.activity,
				this.sleeper);
		this.viewUtils = new ViewUtils(this.inst, activityUtils, sleeper);
		this.clickUtils = new ClickUtils(this.inst, this.activity);
		this.scrollUtils = new ScrollUtils(this.inst, this.activityUtils, this.viewUtils, this.sleeper);
	}

	/**
	 * Constructor of {@link Tmts}.
	 * 
	 * @param inst
	 *            {@link Instrumentation}.
	 * @param activity
	 *            {@link Activity}.
	 * @param targetPkg
	 *            Package name of the app under test.
	 */
	public Tmts(Instrumentation inst, Activity activity, String targetPkg) {
		this(inst, activity);
		Tmts.targetPkg = targetPkg;
	}

	/**
	 * @param id
	 *            Id of the {@link View}.
	 * @return {@link TmtsView} by the given id.
	 */
	TmtsView findTmtsViewById(int id) {
		View view = activity.findViewById(id);
		TmtsView tmtsView = new TmtsView(inst, view);
		return tmtsView;
	}

	/**
	 * Finds a {@link TmtsButton} that was identified by the id attribute from
	 * the XML.
	 * 
	 * @param id
	 *            Id of {@link Button}.
	 * @return {@link TmtsButton}.
	 * @deprecated Must import the app code.
	 */
	TmtsButton findButtonById(int id) {
		Button btn = (Button) activity.findViewById(id);
		TmtsButton tmtsButton = new TmtsButton(inst, btn);
		return tmtsButton;
	}

	/**
	 * Finds a {@link TmtsTextView} that was identified by the id attribute from
	 * the XML.
	 * 
	 * @param id
	 *            Id of {@link TextView}.
	 * @return {@link TmtsTextView} by the given id.
	 * @deprecated Must import the app code.
	 */
	TmtsTextView findTextViewById(int id) {
		TextView textView = (TextView) activity.findViewById(id);
		TmtsTextView tmtsTextView = new TmtsTextView(inst, textView);
		return tmtsTextView;
	}

	/**
	 * Finds a {@link TmtsCheckBox} that was identified by the id attribute from
	 * the XML.
	 * 
	 * @param id
	 *            Id of {@link CheckBox}.
	 * @return {@link TmtsCheckBox} by the given id.
	 * @deprecated Must import the app code.
	 */
	TmtsCheckBox findCheckBoxById(int id) {
		CheckBox checkBox = (CheckBox) activity.findViewById(id);
		TmtsCheckBox tmtsCheckBox = new TmtsCheckBox(inst, checkBox);
		return tmtsCheckBox;
	}

	/**
	 * Finds a {@link TmtsEditText} that was identified by the id attribute from
	 * the XML.
	 * 
	 * @param id
	 *            Id of {@link EditText}.
	 * @return {@link TmtsEditText} by the given id.
	 * @deprecated Must import the app code.
	 */
	TmtsEditText findEditTextById(int id) {
		EditText editText = (EditText) activity.findViewById(id);
		TmtsEditText tmtsEditText = new TmtsEditText(inst, editText);
		return tmtsEditText;
	}

	/**
	 * Finds a {@link TmtsAutoCompleteTextView} that was identified by the id
	 * attribute from the XML.
	 * 
	 * @param id
	 *            Id of {@link AutoCompleteTextView}.
	 * @return {@link TmtsAutoCompleteTextView} by the given id.
	 * @deprecated Must import the app code.
	 */
	TmtsAutoCompleteTextView findAutoCompleteTextViewById(int id) {
		AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) activity
				.findViewById(id);
		TmtsAutoCompleteTextView tmtsAutoCompleteTextView = new TmtsAutoCompleteTextView(
				inst, autoCompleteTextView);
		return tmtsAutoCompleteTextView;
	}

	/**
	 * Finds a {@link TmtsImageView} that was identified by the id attribute
	 * from the XML.
	 * 
	 * @param id
	 *            Id of {@link ImageView}.
	 * @return {@link TmtsImageView} by the given id.
	 * @deprecated Must import the app code.
	 */
	TmtsImageView findImageViewById(int id) {
		ImageView imageView = (ImageView) activity.findViewById(id);
		TmtsImageView tmtsImageView = new TmtsImageView(inst, imageView);
		return tmtsImageView;
	}

	/**
	 * Finds a {@link TmtsImageButton} that was identified by the id attribute
	 * from the XML.
	 * 
	 * @param id
	 *            Id of {@link ImageButton}.
	 * @return {@link TmtsImageButton} by the given id.
	 * @deprecated Must import the app code.
	 */
	TmtsImageButton findImageButtonById(int id) {
		ImageButton imageButton = (ImageButton) activity.findViewById(id);
		TmtsImageButton tmtsImageButton = new TmtsImageButton(inst, imageButton);
		return tmtsImageButton;
	}

	/**
	 * Finds a {@link TmtsListView} that was identified by the id attribute from
	 * the XML.
	 * 
	 * @param id
	 *            Id of {@link ListView}.
	 * @return {@link TmtsListView} by the given id.
	 * @deprecated Must import the app code.
	 */
	TmtsListView findListViewById(int id) {
		ListView listView = (ListView) activity.findViewById(id);
		TmtsListView tmtsListView = new TmtsListView(inst, listView);
		return tmtsListView;
	}

	/**
	 * Finds a {@link TmtsScrollView} that was identified by the id attribute
	 * from the XML.
	 * 
	 * @param id
	 *            Id of {@link ScrollView}.
	 * @return {@link TmtsScrollView} by the given id.
	 * @deprecated Must import the app code.
	 */
	TmtsScrollView findScrollViewById(int id) {
		ScrollView scrollView = (ScrollView) activity.findViewById(id);
		TmtsScrollView tmtsScrollView = new TmtsScrollView(inst, scrollView);
		return tmtsScrollView;
	}

	/**
	 * Finds a {@link TmtsWebView} that was identified by the id attribute from
	 * the XML.
	 * 
	 * @param id
	 *            Id of {@link WebView}.
	 * @return {@link TmtsWebView} by the given id.
	 * @deprecated Must import the app code.
	 */
	TmtsWebView findWebViewById(int id) {
		WebView webView = (WebView) activity.findViewById(id);
		TmtsWebView tmtsWebView = new TmtsWebView(inst, webView);
		return tmtsWebView;
	}

	/**
	 * Return a {@link Resources} instance for your application's package.
	 * 
	 * @return Resources instance for your application's package.
	 */
	Resources getResources() {
		return activity.getResources();
	}

	/**
	 * Returns the raw height of the display, in pixels.
	 * 
	 * @return the raw height of the display, in pixels
	 */
	int getHeight() {
		Log.i(LOG_TAG, "getHeight(): "
				+ activity.getWindowManager().getDefaultDisplay().getHeight());
		return activity.getWindowManager().getDefaultDisplay().getHeight();
	}

	/**
	 * Returns the raw width of the display, in pixels.
	 * 
	 * @return the raw width of the display, in pixels.
	 */
	int getWidth() {
		Log.i(LOG_TAG, "getHeight(): "
				+ activity.getWindowManager().getDefaultDisplay().getWidth());
		return activity.getWindowManager().getDefaultDisplay().getWidth();
	}
    
	/**
	 * 
	 * @param <T>
	 * @param idTree
	 * @param caster
	 * @return
	 * @throws Exception
	 */
	<T extends TmtsView> T getTmtsViewInTree(String idTree, Class<T> caster) throws Exception {
		TmtsView tmtsView = null;
		String[] ids = idTree.split(">");
		
		if (ids.length == 1) {
			tmtsView = getTmtsView(ids[0]);
		} else if (ids.length > 1) {
			tmtsView = getTmtsView(ids[0]);
			for (int i = 1; i < ids.length; i++) {
				tmtsView = tmtsView.findTmtsViewById(ids[i], caster);
			}
		}
		return caster.cast(tmtsView);
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
	TmtsView getTmtsView(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsView: " + name);
		View view = (View) getView(name, View.class);
		printLog(view, name, "getTmtsView");
		TmtsView tmtsView = new TmtsView(inst, view);
		return tmtsView;
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
	TmtsButton getTmtsButton(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsButton: " + name);
		Button button = (Button) getView(name, Button.class);
		printLog(button, name, "getTmtsButton");
		TmtsButton tmtsButton = new TmtsButton(inst, button);
		return tmtsButton;
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
	TmtsTextView getTmtsTextView(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsTextView: " + name);
		TextView textView = (TextView) getView(name, TextView.class);
		printLog(textView, name, "getTmtsTextView");
		TmtsTextView tmtsTextView = new TmtsTextView(inst, textView);
		return tmtsTextView;
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
	TmtsCheckBox getTmtsCheckBox(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsCheckBox: " + name);
		CheckBox checkBox = (CheckBox) getView(name, CheckBox.class);
		printLog(checkBox, name, "getTmtsCheckBox");
		TmtsCheckBox tmtsCheckBox = new TmtsCheckBox(inst, checkBox);
		return tmtsCheckBox;
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
	TmtsEditText getTmtsEditText(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsEditText: " + name);
		EditText editText = getView(name, EditText.class);
		printLog(editText, name, "getTmtsEditText");
		TmtsEditText tmtsEditText = new TmtsEditText(inst, editText);
		return tmtsEditText;
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
	TmtsImageView getTmtsImageView(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsImageView: " + name);
		ImageView imageView = (ImageView) getView(name, ImageView.class);
		printLog(imageView, name, "getTmtsImageView");
		TmtsImageView tmtsImageView = new TmtsImageView(inst, imageView);
		return tmtsImageView;
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
	TmtsImageButton getTmtsImageButton(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsImageButton: " + name);
		ImageButton imageButton = (ImageButton) getView(name, ImageButton.class);
		printLog(imageButton, name, "getTmtsImageButton");
		TmtsImageButton tmtsImageButton = new TmtsImageButton(inst, imageButton);
		return tmtsImageButton;
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
	TmtsListView getTmtsListView(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsListView: " + name);
		ListView listView = (ListView) getView(name, ListView.class);
		printLog(listView, name, "getTmtsListView");
		TmtsListView tmtsListView = new TmtsListView(inst, listView);
		tmtsListView.init(this.clickUtils);
//		tmtsListView.init(activity);
		return tmtsListView;
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
	TmtsScrollView getTmtsScrollView(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsScrollView: " + name);
		ScrollView scrollView = (ScrollView) getView(name, ScrollView.class);
		printLog(scrollView, name, "getTmtsScrollView");
		TmtsScrollView tmtsScrollView = new TmtsScrollView(inst, scrollView);
		return tmtsScrollView;
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
	TmtsAutoCompleteTextView getTmtsAutoCompleteTextView(String name)
			throws Exception {
		Log.i(LOG_TAG, "getTmtsAutoCompleteTextView: " + name);
		AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) getView(
				name, AutoCompleteTextView.class);
		printLog(autoCompleteTextView, name, "getTmtsAutoCompleteTextView");
		TmtsAutoCompleteTextView tmtsAutoCompleteTextView = new TmtsAutoCompleteTextView(
				inst, autoCompleteTextView);
		return tmtsAutoCompleteTextView;
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
	TmtsProgressBar getTmtsProgressBar(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsProgressBar: " + name);
		ProgressBar progressBar = (ProgressBar) getView(name, ProgressBar.class);
		printLog(progressBar, name, "progressBar");
		TmtsProgressBar tmtsProgressBar = new TmtsProgressBar(inst, progressBar);
		return tmtsProgressBar;
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
	TmtsWebView getTmtsWebView(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsWebView: " + name);
		WebView webView = (WebView) getWebViewById(name);
		while (!(webView.getProgress() == 100)) {
			Thread.sleep(1000);
			Log.i(LOG_TAG, "sleep: " + webView.getProgress());
		}
		printLog(webView, name, "getTmtsWebView");
		Log.i(LOG_TAG, "getTmtsWebView: " + webView + " success");
		Log.i(LOG_TAG, "getTmtsWebViewurl: " + webView.getUrl() + " success");
		Thread.sleep(2000);
		TmtsWebView tmtsWebView = new TmtsWebView(inst, webView);
	
		return tmtsWebView;
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
	TmtsRelativeLayout getTmtsRelativeLayout(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsRelativeLayout: " + name);
		RelativeLayout relativeLayout = (RelativeLayout) getView(name,
				RelativeLayout.class);
		printLog(relativeLayout, name, "getTmtsRelativeLayout");
		TmtsRelativeLayout tmtsRelativeLayout = new TmtsRelativeLayout(inst,
				relativeLayout);
		return tmtsRelativeLayout;
	}

	/**
	 * Do not useful anymore.
	 * 
	 * @param tmtsWebView
	 */
	void setTmtsWebView(TmtsWebView tmtsWebView) {
		this.currentView = tmtsWebView;

	}

	/**
	 * Do not useful anymore.
	 * 
	 * @param tmtsWebView
	 */
	TmtsWebView getTmtsWebView() {
		return currentView;
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
	TmtsViewFlipper getTmtsViewFlipper(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsViewFlipper: " + name);
		ViewFlipper viewFlipper = (ViewFlipper) getView(name, ViewFlipper.class);
		printLog(viewFlipper, name, "getTmtsViewFlipper");
		TmtsViewFlipper tmtsViewFlipper = new TmtsViewFlipper(inst, viewFlipper);
		return tmtsViewFlipper;
	}
	
	TmtsCheckedTextView getTmtsCheckedTextView(String name) throws Exception {
		Log.i(LOG_TAG, "getTmtsCheckedTextView: " + name);
		CheckedTextView checkedTextView = (CheckedTextView) getView(name, CheckedTextView.class);
		printLog(checkedTextView, name, "getTmtsCheckedTextView");
		TmtsCheckedTextView tmtsCheckedTextView = new TmtsCheckedTextView(inst, checkedTextView);
		return tmtsCheckedTextView;
	}
	
	/**
	 * 
	 * @param <T>
	 * @param name
	 * @param caster
	 * @return
	 * @throws Exception
	 */
	<T extends TmtsView> T getTmtsView(String name, Class<T> caster) throws Exception {
		Constructor<?>[] constructors = caster.getDeclaredConstructors();
		Object obj = constructors[0].newInstance(inst, getView(name, View.class));
		return caster.cast(obj);
	}

	/**
	 * Return a {@link TmtsButton} with the given text content, use this method
	 * to find a button belongs to a dialog.
	 * 
	 * @param text
	 *            Content text of the button.
	 * @return {@link TmtsButton} with the given text content
	 */
	TmtsButton findTmtsButton(String text) {
		Log.i(LOG_TAG, "findTmtsButton: " + text);
		if (findButton(text) != null) {
			Log.i(LOG_TAG, "findTmtsButton: " + text + " succeed");
			return new TmtsButton(inst, findButton(text));
		}
		Log.i(LOG_TAG, "findTmtsButton: " + text + " failed, return null");
		return null;
	}

	/**
	 * Return a {@link View} by the given name.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @param classToFilterBy
	 *            Specified sub-class of {@link View}, such as {@link TextView}.
	 * @return {@link View} with the given name.
	 * @throws NoSuchFieldException
	 * @throws Exception
	 *             Exception.
	 */
	@SuppressWarnings("deprecation")
	<T extends View> T getView(String name, Class<T> classToFilterBy)
			throws Exception {
		int id = getIdByName(name);

		if (id == -1) {
			TmtsLog.e(LOG_TAG, "View which name is " + name
					+ " does not exists in R.java");
			return null;
		}

		if (getViewById(id, classToFilterBy) == null) {

			TmtsLog.e(LOG_TAG, "View which id is " + name + " is null");
			return null;

		} else {
			Log.i(LOG_TAG, "getView:" + name);
			return getViewById(id, classToFilterBy);
		}
	}

	/**
	 * Return a {@link Button} with the given text content.
	 * 
	 * @param text
	 *            Content text of the button.
	 * @return {@link Button} with the given text content.
	 * @throws InterruptedException
	 *             InterruptedException.
	 */
	@SuppressWarnings("deprecation")
	private Button findButton(String text) {
		final long startTime = System.currentTimeMillis();

		while (System.currentTimeMillis() < startTime
				+ Constants.FIND_VIEW_TIME_OUT) {
			ArrayList<View> all = viewUtils.getAllViews(true);
			for (int i = 0; i < all.size(); i++) {
				if (all.get(i) instanceof Button) {
					if (((Button) all.get(i)).getText().toString()
							.equalsIgnoreCase(text)) {
						return (Button) all.get(i);
					}
				}
			}
			try {
				Thread.sleep(Constants.RETRY_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		TmtsLog.e(LOG_TAG, "button which text is " + text + " does not found ");
		return null;
	}

	/**
	 * Return the {@link View} by the id.
	 * 
	 * @param id
	 *            Id of {@link View}.
	 * @param classToFilterBy
	 *            Specified sub-class of {@link View}, such as {@link TextView}.
	 * @return {@link View} by the given id.
	 * @throws InterruptedException
	 *             InterruptedException.
	 */
	@SuppressWarnings("deprecation")
	private <T extends View> T getViewById(final int id,
			Class<T> classToFilterBy) {
		final long startTime = System.currentTimeMillis();
//        activityUtils.getCurrentActivity();
		while (System.currentTimeMillis() < startTime
				+ Constants.FIND_VIEW_TIME_OUT) {
			ArrayList<View> all = viewUtils.getAllViews(true);
			for (int i = 0; i < all.size(); i++) {
				if (all.get(i).getId() == id) {

					Log.i(LOG_TAG, "The view which id is " + id

							+ " found succeed");
					View view = all.get(i);
					classToFilterBy.isAssignableFrom(view.getClass());
					T viewT = classToFilterBy.cast(view);		
					return viewT;
				}
			}

			try {
				Log.i(LOG_TAG, "View which id is " + id
						+ " does not found, sleep");
				Thread.sleep(Constants.RETRY_TIME);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		TmtsLog.e(LOG_TAG, "View which id is " + id + " does not found in "
				+ Constants.FIND_VIEW_TIME_OUT / 1000 + "seconds, time out");
		return null;
	}
	
	@SuppressWarnings("deprecation")
	private WebView getWebViewById(String name) throws Exception{
		final long startTime = System.currentTimeMillis();
		int id = getIdByName(name);
//        activityUtils.getCurrentActivity();
		while (System.currentTimeMillis() < startTime
				+ Constants.FIND_VIEW_TIME_OUT) {
			ArrayList<View> all = viewUtils.getAllViews(true);
			for (int i = 0; i < all.size(); i++) {
				if ((all.get(i).getId() == id)) {
					Log.i(LOG_TAG, "The view which id is: "+ i +":"+ all.get(i).getId()
							+ " found succeed");
					WebView view = (WebView) all.get(i);
//					
//				    view.addJavascriptInterface(JavascriptInterface.getInstance(), "webdriver");
//					view.loadUrl("javascript:var result=[];" +				
//					        "  var element = document.getElementById('J_Postage');" +
//					        "  if (element != null) {" +
//					        "    result.push(element)};"); 	
//					Log.d(LOG_TAG, view.getUrl() + "");
//				    view.loadUrl("javascript:window.webdriver.excutejs(element)");
//				    view.loadUrl("javascript:window.webdriver.excutejs(result[0])");
//				    JavascriptInterface.getInstance().getResult();
					return view;
				}
			}

			try {
				Log.i(LOG_TAG, "View which id is " + id
						+ " does not found, sleep");
				Thread.sleep(Constants.RETRY_TIME);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		TmtsLog.e(LOG_TAG, "View which id is " + id + " does not found in "
				+ Constants.FIND_VIEW_TIME_OUT / 1000 + "seconds, time out");
		return null;
	}

	/**
	 * Transform {@link String} id into {@link int} id.
	 * 
	 * @param name
	 *            String name of view id, the string after @+id/ defined in
	 *            layout files.
	 * @return {@link View}'s id defined in R.java.
	 * @throws Exception
	 *             Exception.
	 */
	public static int getIdByName(String name) throws Exception {
		String className = targetPkg + ".R$id";
		Class<?> id = null;
		id = Class.forName(className);
		Field idField = null;
		idField = id.getField(name);

		if (null != idField) {
			return idField.getInt(idField);

		} else {
			return -1;
		}

	}
	
	/**
	 * Click a button on dialog by text,
	 * 
	 * @param buttonText
	 *            Text of the button,
	 * @throws InterruptedException
	 *             InterruptedException,
	 */
	void clickDialogButton(String buttonText)
			throws InterruptedException {
		final TmtsButton button = findTmtsButton(buttonText);

		if (null != button) {
			button.doClick();
		}
	}

	/**
	 * Click on {@link View} by the given text.
	 * 
	 * @param text
	 *            Text of the view.
	 * @throws InterruptedException 
	 */
	void clickOnViewByText(String text) throws InterruptedException {
		clickUtils.clickOnText(text, false, 1, true, 0);
	}
	
	/**
	 * Scrolls up.
	 * 
	 * @return {@code true} if more scrolling can be done.
	 * 
	 */
	boolean scrollUp() {
		return scrollUtils.scroll(Constants.UP);
	}
	
	/**
	 * Scroll down.
	 * @return {@code true} if more scrolling can be done.
	 */
	boolean scrollDown() {
		return scrollUtils.scroll(Constants.DOWN);
	}
	
	
	/**
	 * Perform full scroll to top.
	 */
	void fullScrollUp() {
		while (scrollUp()) {
			scrollUp();
		}
	}
	
	/**
	 * Perform full scroll to bottom.
	 */
	void fullScrollDown() {
		while (scrollDown()) {
			scrollDown();
		}
	}
	
	boolean scrollListDown() {
		try {
			Thread.sleep(Constants.ANR_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return scrollUtils.scrollList(ListView.class, 0, Constants.DOWN, null);
	}
	
	boolean scrollListUp() {
		try {
			Thread.sleep(Constants.ANR_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return scrollUtils.scrollList(ListView.class, 0, Constants.UP, null);
	}
	
	void scrollListBottom() {
		while (scrollListDown()) {
			scrollListDown();
		}
	}
	
	void scrollListTop() {
		while (scrollListUp()) {
			scrollListUp();
		}
	}
	
	protected void finalize() {
		try {
			activityUtils.finalize();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * Private method to print log in this class.
	 * 
	 * @param view
	 *            view
	 * @param name
	 *            name of view
	 * @param getMethod
	 *            Name of the method.
	 */
	@SuppressWarnings("deprecation")
	private static void printLog(View view, String name, String getMethod) {
		
		if (null != view) {
			Log.i(LOG_TAG, getMethod + ": " + name + " succeed");
			
		} else {
			TmtsLog.e(LOG_TAG, getMethod + ": " + name + " failed");
		}
	}
}
