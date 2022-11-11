
package com.emat;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class onboarding_3_activity extends Activity {

	
	private View __bg__onboarding_3_ek2;
	private ImageView sarah_noltner_pm9397vvffy_unsplash_1;
	private TextView e_mat_ek3;
	private TextView grab_the_most_convenient_deals_around;
	private TextView we_understand_every_student_and_therefore_strive_to_offer_the_most_rides_;
	private View button_container_ek2;
	private TextView button_ek2;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_3);

		
		__bg__onboarding_3_ek2 = (View) findViewById(R.id.__bg__onboarding_3_ek2);
		e_mat_ek3 = (TextView) findViewById(R.id.e_mat_ek3);
		grab_the_most_convenient_deals_around = (TextView) findViewById(R.id.grab_the_most_convenient_deals_around);
		we_understand_every_student_and_therefore_strive_to_offer_the_most_rides_ = (TextView) findViewById(R.id.we_understand_every_student_and_therefore_strive_to_offer_the_most_rides_);
//		button_container_ek2 = (View) findViewById(R.id.button_container_ek2);
		button_ek2 = (TextView) findViewById(R.id.button_ek2);
	
		
		button_ek2.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), get_started_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


		});
		
		

	}
}
	
	