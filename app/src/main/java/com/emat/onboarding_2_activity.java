package com.emat;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class onboarding_2_activity extends Activity {

	
	private View __bg__onboarding_2_ek2;
	private ImageView alexandre_debieve_ohnbtfe9_ie_unsplash_1;
	private TextView e_mat_ek2;
	private TextView safe_drop_off_and_pickup;
	private TextView get_picked_up_at_our_numerous_safe_pickup_locations_all_across_the_city__;
	private View button_container_ek1;
	private TextView button_ek1;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.onboarding_2);

		
		__bg__onboarding_2_ek2 = (View) findViewById(R.id.__bg__onboarding_2_ek2);
		e_mat_ek2 = (TextView) findViewById(R.id.e_mat_ek2);
		safe_drop_off_and_pickup = (TextView) findViewById(R.id.safe_drop_off_and_pickup);
		get_picked_up_at_our_numerous_safe_pickup_locations_all_across_the_city__ = (TextView) findViewById(R.id.get_picked_up_at_our_numerous_safe_pickup_locations_all_across_the_city__);
//		button_container_ek1 = (View) findViewById(R.id.button_container_ek1);
		button_ek1 = (TextView) findViewById(R.id.button_ek1);
	
		
		button_ek1.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), onboarding_3_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


		});
		
		

	}
}
	
	