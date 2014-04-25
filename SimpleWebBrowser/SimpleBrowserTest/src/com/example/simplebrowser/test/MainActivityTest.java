package com.example.simplebrowser.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.example.simplebrowser.MainActivity;
import com.example.simplebrowser.R;
/**
 * @author Amruta
 * 
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mainActivity;
	private Button btnGo;
	private EditText urlAddress;
	private WebView webView;
	private Button btnBack;
	private Button btnForward;
	private Button btnClear;
	private  MenuItem menu_bookmark;
	protected MenuItem menu_save;
	protected MenuItem menu_home;

	@SuppressWarnings({ "deprecation" })
	public MainActivityTest() {
		super("com.example.simplebrowser", MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		 mainActivity = (MainActivity) getActivity();  
	}

	
	public void testGoButton(){
		try {
			runTestOnUiThread(new Runnable() {
			   public void run(){   
			    
			  urlAddress =  (EditText)mainActivity.findViewById(R.id.url_address);
			  urlAddress.setText("http://www.google.com");
			  btnGo =  (Button)mainActivity.findViewById(R.id.buttonGo);
			  btnGo.callOnClick();
			  webView =  (WebView)mainActivity.findViewById(R.id.webView);
			  assertEquals(webView.getUrl(),"http://www.google.com");
			    }
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void testBackButton(){
		try {
			runTestOnUiThread(new Runnable() {
			  

			public void run(){   
			    
			  urlAddress =  (EditText)mainActivity.findViewById(R.id.url_address);
			  urlAddress.setText("http://www.google.com");
			  btnGo =  (Button)mainActivity.findViewById(R.id.buttonGo);
			  btnGo.callOnClick();
			  urlAddress.setText("http://www.facebook.com");
			  btnGo.callOnClick();
			  webView =  (WebView)mainActivity.findViewById(R.id.webView);
			  btnBack =  (Button)mainActivity.findViewById(R.id.buttonBack);
			  btnBack.callOnClick();
			  assertEquals(webView.getUrl(),"http://www.google.com");
			    }
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void testForwardButton(){
		try {
			runTestOnUiThread(new Runnable() {
			  

			public void run(){   
			    
			  urlAddress =  (EditText)mainActivity.findViewById(R.id.url_address);
			  urlAddress.setText("http://www.google.com");
			  btnGo =  (Button)mainActivity.findViewById(R.id.buttonGo);
			  btnGo.callOnClick();
			  urlAddress.setText("http://www.facebook.com");
			  btnGo.callOnClick();
			  webView =  (WebView)mainActivity.findViewById(R.id.webView);
			  btnBack =  (Button)mainActivity.findViewById(R.id.buttonBack);
			  btnBack.callOnClick();
			  btnForward =  (Button)mainActivity.findViewById(R.id.buttonForward);
			  btnForward.callOnClick();
			  assertEquals(webView.getUrl(),"http://www.facebook.com");
			    }
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void testClearButton(){
		try {
			runTestOnUiThread(new Runnable() {
			  

			public void run(){   
			    
			  urlAddress =  (EditText)mainActivity.findViewById(R.id.url_address);
			  urlAddress.setText("http://www.google.com");
			  btnGo =  (Button)mainActivity.findViewById(R.id.buttonGo);
			  btnGo.callOnClick();
			  assertEquals(webView.getUrl(),"http://www.google.com");
			  
			  btnClear=  (Button)mainActivity.findViewById(R.id.buttonClear);
			  btnClear.callOnClick();
			  assertEquals(webView.getUrl(),"");
			    }
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void testWebView(){
		try {
			runTestOnUiThread(new Runnable() {
			  

			public void run(){   
			    
				  urlAddress =  (EditText)mainActivity.findViewById(R.id.url_address);
				  urlAddress.setText("http://www.google.com");
				  btnGo =  (Button)mainActivity.findViewById(R.id.buttonGo);
				  btnGo.callOnClick();
				  webView =  (WebView)mainActivity.findViewById(R.id.webView);
				  assertEquals(webView.getUrl(),"http://www.google.com");
			    }
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void testErrorInWebView(){
		try {
			runTestOnUiThread(new Runnable() {
			  

			public void run(){   
			    
				  urlAddress =  (EditText)mainActivity.findViewById(R.id.url_address);
				  urlAddress.setText("invalid url");
				  btnGo =  (Button)mainActivity.findViewById(R.id.buttonGo);
				  assertFalse(btnGo.callOnClick());

			    }
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void testOpenAndSaveBookmark(){
		try {
			runTestOnUiThread(new Runnable() {
			  

			public void run(){   
			    
				  urlAddress =  (EditText)mainActivity.findViewById(R.id.url_address);
				  urlAddress.setText("http://www.facebook.com");
				  btnGo =  (Button)mainActivity.findViewById(R.id.buttonGo);
				  btnGo.callOnClick();
				  menu_save =  (MenuItem) mainActivity.findViewById(R.id.menu_save);
				  menu_save.getActionProvider().onPerformDefaultAction();
				  
				  menu_bookmark =  (MenuItem) mainActivity.findViewById(R.id.menu_bookmark);
				  				  
				  assertEquals(webView.getUrl(),menu_bookmark.getTitle());
			    }
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void testHomeMenu(){
		try {
			runTestOnUiThread(new Runnable() {
			  

			public void run(){   
			    
				  urlAddress =  (EditText)mainActivity.findViewById(R.id.url_address);
				  urlAddress.setText("http://www.facebook.com");
				  btnGo =  (Button)mainActivity.findViewById(R.id.buttonGo);
				  btnGo.callOnClick();
				  menu_home =  (MenuItem) mainActivity.findViewById(R.id.menu_home);
				  menu_home.getActionProvider().onPerformDefaultAction();
				  
				  assertEquals(webView.getUrl(),"http://www.google.com");
			    }
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
