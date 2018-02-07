package com.tesla;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);
		TextView enter=(TextView) findViewById(R.id.enter);
		Typeface handType = Typeface.createFromAsset(getBaseContext()
				.getAssets(), "fonts/neuro.TTF");

		// e1.setTypeface(handType);
		// e2.setTypeface(handType);
		enter.setTypeface(handType);
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent intent=new Intent(MainActivity.this,description.class);
				 startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
