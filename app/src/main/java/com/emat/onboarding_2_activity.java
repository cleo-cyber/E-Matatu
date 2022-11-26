package com.emat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class onboarding_2_activity extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_2);


		findViewById(R.id.__bg__onboarding_2_ek2);
		findViewById(R.id.e_mat_ek2);
		findViewById(R.id.safe_drop_off_and_pickup);
		TextView button_ek1 = (TextView) findViewById(R.id.button_ek1);
	
		
		button_ek1.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), onboarding_3_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


		});
		
		

	}
}
	
	