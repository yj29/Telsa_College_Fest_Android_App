package com.tesla;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class workshop extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.workshop);
		TextView android=(TextView) findViewById(R.id.android);
		TextView ethical=(TextView) findViewById(R.id.ethical);
		TextView auto=(TextView) findViewById(R.id.auto);;
		TextView robotics=(TextView) findViewById(R.id.robotics);
		Typeface handType = Typeface.createFromAsset(getBaseContext()
				.getAssets(), "fonts/neuro.TTF");
		android.setTypeface(handType);
		ethical.setTypeface(handType);
		auto.setTypeface(handType);
		robotics.setTypeface(handType);
	}

}
