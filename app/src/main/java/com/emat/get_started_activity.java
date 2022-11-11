
package com.emat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;

public class get_started_activity extends Activity {


	private View button_container_ek3;
	private View button_container_ek4;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.get_started);


		View _bg__get_started_ek2 = (View) findViewById(R.id._bg__get_started_ek2);
		TextView e_mat_ek4 = (TextView) findViewById(R.id.e_mat_ek4);
		TextView get_started_ek3 = (TextView) findViewById(R.id.get_started_ek3);
		TextView button_ek3 = (TextView) findViewById(R.id.button_ek3);
		TextView button_ek4 = (TextView) findViewById(R.id.button_ek4);
	
		
		button_ek3.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), login_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


		});

		button_ek4.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				Intent nextScreen = new Intent(getApplicationContext(), register_activity.class);
				startActivity(nextScreen);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


			}
		});
	
	}
}
	
	