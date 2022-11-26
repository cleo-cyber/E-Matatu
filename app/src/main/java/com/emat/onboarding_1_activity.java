package com.emat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class onboarding_1_activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {



		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_1);


		TextView next = (TextView) findViewById(R.id.button);

		findViewById(R.id.__bg__onboarding_1_ek2);
		findViewById(R.id.e_mat);
		findViewById(R.id.convenient_cheap_rides);

		
		next.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), onboarding_2_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


		});
		
		

	}
}
	
	