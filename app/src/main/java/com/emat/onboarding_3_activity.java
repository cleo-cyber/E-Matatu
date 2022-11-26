
package com.emat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class onboarding_3_activity extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_3);


		findViewById(R.id.__bg__onboarding_3_ek2);
		findViewById(R.id.e_mat_ek3);
		findViewById(R.id.grab_the_most_convenient_deals_around);
		TextView button_ek2 = (TextView) findViewById(R.id.button_ek2);
	
		
		button_ek2.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), get_started_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


		});
		
		

	}
}
	
	