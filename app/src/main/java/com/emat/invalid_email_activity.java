
package com.emat;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class invalid_email_activity extends Activity {


	private TextView time;
	private View border;
	private ImageView cap;
	private View capacity;
	private ImageView wifi;
	private ImageView cellular_connection;
	private View home_indicator;
	private View button_container;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.invalid_email);


		View _bg__invalid_email = (View) findViewById(R.id._bg__invalid_email);
		ImageView vector = (ImageView) findViewById(R.id.vector);
		ImageView vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		TextView forgot_password = (TextView) findViewById(R.id.forgot_password);
		findViewById(R.id.we_ll_send_a_password_reset_link_to_your_email_);
		TextView ewmail_does_not_exist__rty_again_ = (TextView) findViewById(R.id.email_does_not_exist__rty_again_);
		TextView label = (TextView) findViewById(R.id.label);
		View input_container = (View) findViewById(R.id.input_container);
		TextView button = (TextView) findViewById(R.id.button);
	
		

	}
}
	
	