package com.tesla;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class description extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.description);
		
		TextView workshop=(TextView) findViewById(R.id.workshop);
		TextView competition=(TextView) findViewById(R.id.competition);
		TextView locate=(TextView) findViewById(R.id.locate);;
		TextView contact=(TextView) findViewById(R.id.contact);
		TextView website=(TextView) findViewById(R.id.website);
		Typeface handType = Typeface.createFromAsset(getBaseContext()
				.getAssets(), "fonts/neuro.TTF");
		workshop.setTypeface(handType);
		competition.setTypeface(handType);
		locate.setTypeface(handType);
		contact.setTypeface(handType);
		website.setTypeface(handType);
		
		workshop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent intent=new Intent(description.this,workshop.class);
			startActivity(intent);
			}
		});
		
		website.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent= new Intent(description.this,website.class);
				startActivity(intent);
			}
		});
		
		contact.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent= new Intent(description.this,contact_us.class);
				startActivity(intent);
			}
		});
		
		locate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent= new Intent(description.this,mapactivity.class);
				startActivity(intent);
			}
		});
		
	}

}
