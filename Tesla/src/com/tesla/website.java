package com.tesla;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class website extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		this.requestWindowFeature(Window.FEATURE_PROGRESS);
	    this.setProgressBarVisibility(true);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.website);
		WebView mWebView=(WebView) findViewById(R.id.webView1);
		Toast.makeText(getApplicationContext(), "Loading...Please Wait!!", Toast.LENGTH_LONG).show();
		mWebView.getSettings().setJavaScriptEnabled(true);
		 mWebView.getSettings().setSupportZoom(true);
         mWebView.getSettings().setBuiltInZoomControls(true);
	        mWebView.setWebViewClient(new WebViewClient());
	        mWebView.loadUrl("http://www.tesla.org.in/");
	}

}
