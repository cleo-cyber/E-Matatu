package com.emat;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class onboarding_1_activity extends Activity {

	
	private View __bg__onboarding_1_ek2;
	private ImageView majestic_lukas_ipsd4z55_rw_unsplash_1;
	private TextView e_mat;
	private TextView text;
	private TextView convenient_cheap_rides;
	private TextView book_timely___pocket_friendly_rides_remotely_from_your_mobile_device_;
	private View button_container;
	private TextView button;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_1);

		
		__bg__onboarding_1_ek2 = (View) findViewById(R.id.__bg__onboarding_1_ek2);
		e_mat = (TextView) findViewById(R.id.e_mat);
		text = (TextView) findViewById(R.id.text);
		convenient_cheap_rides = (TextView) findViewById(R.id.convenient_cheap_rides);
		book_timely___pocket_friendly_rides_remotely_from_your_mobile_device_ = (TextView) findViewById(R.id.book_timely___pocket_friendly_rides_remotely_from_your_mobile_device_);
//		button_container = (View) findViewById(R.id.button_container);
		button = (TextView) findViewById(R.id.button);
	
		
		button.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), onboarding_2_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


		});
		
		

	}
}
	
	