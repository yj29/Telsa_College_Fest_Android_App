package com.tesla;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class contact_us extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_us);
		TextView head=(TextView) findViewById(R.id.head_contact);
		TextView c1=(TextView) findViewById(R.id.c1);
		TextView textView1=(TextView) findViewById(R.id.textView1);
		Typeface handType = Typeface.createFromAsset(getBaseContext()
				.getAssets(), "fonts/neuro.TTF");
		head.setTypeface(handType);
		c1.setTypeface(handType);
		textView1.setTypeface(handType);
		textView1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				/*Intent callIntent = new Intent(Intent.ACTION_CALL);
				String url="+918007614527";
				callIntent.setData(Uri.parse(url));
				startActivity(callIntent);*/				
			}
		});
		
	}

}
