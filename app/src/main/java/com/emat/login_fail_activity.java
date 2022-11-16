
package com.emat;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class login_fail_activity extends Activity {

	
	private View _bg__login_fail;
	private ImageView vector;
	private ImageView vector_ek1;
	private TextView login;
	private TextView label;
	private View input_container;
	private TextView label_ek1;
	private View input_container_ek1;
	private TextView placeholder_ek1;
	private ImageView vector_ek2;
	private ImageView vector_ek3;
	private View button_container;
	private TextView button;
	private TextView _don_t_have_an_account__register;
	private TextView _forgot_password;
	private TextView time;
	private View border;
	private ImageView cap;
	private View capacity;
	private ImageView wifi;
	private ImageView cellular_connection;
	private View home_indicator;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_fail);

		
		_bg__login_fail = (View) findViewById(R.id._bg__login_fail);
		vector = (ImageView) findViewById(R.id.vector);
		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		login = (TextView) findViewById(R.id.login);
		label = (TextView) findViewById(R.id.label);
		input_container = (View) findViewById(R.id.input_container);
		label_ek1 = (TextView) findViewById(R.id.label_ek1);
		input_container_ek1 = (View) findViewById(R.id.input_container_ek1);
		placeholder_ek1 = (TextView) findViewById(R.id.placeholder_ek1);
		vector_ek2 = (ImageView) findViewById(R.id.vector_ek2);
		vector_ek3 = (ImageView) findViewById(R.id.vector_ek3);
		button_container = (View) findViewById(R.id.button_container);
		button = (TextView) findViewById(R.id.button);
		_don_t_have_an_account__register = (TextView) findViewById(R.id._don_t_have_an_account__register);
		_forgot_password = (TextView) findViewById(R.id._forgot_password);
	
		
		_don_t_have_an_account__register.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), register_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		
		_forgot_password.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				
				Intent nextScreen = new Intent(getApplicationContext(), forgot_password_activity.class);
				startActivity(nextScreen);
			
		
			}
		});
		
		

	}
}
	
	