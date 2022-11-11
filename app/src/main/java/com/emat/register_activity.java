
package com.emat;

import android.app.Activity;
import android.os.Bundle;


import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class register_activity extends Activity {


	private ImageView vector_ek1;
	private TextView register_ek3;
	private TextView label;
	private View input_container;
	private TextView placeholder;
	private TextView label_ek1;
	private View input_container_ek1;
	private TextView placeholder_ek1;
	private TextView label_ek2;
	private View input_container_ek2;
	private TextView placeholder_ek2;
	private TextView label_ek3;
	private View input_container_ek3;
	private TextView placeholder_ek3;
	private ImageView vector_ek2;
	private ImageView vector_ek3;
	private View button_container_ek5;
	private TextView button_ek5;
	private TextView _already_have_an_account__login;
	private TextView time;
	private View border;
	private ImageView cap;
	private View capacity;
	private ImageView wifi;
	private ImageView cellular_connection;
	private View home_indicator;

	private FirebaseAuth mAuth;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		mAuth = FirebaseAuth.getInstance();


		View _bg__register_ek2 = (View) findViewById(R.id._bg__register_ek2);
		ImageView vector = (ImageView) findViewById(R.id.vector);
		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		register_ek3 = (TextView) findViewById(R.id.register_ek3);
//		input_container = (View) findViewById(R.id.input_container);
//		input_container_ek1 = (View) findViewById(R.id.input_container_ek1);
		placeholder_ek1 = (TextView) findViewById(R.id.placeholder_ek1);
//		input_container_ek2 = (View) findViewById(R.id.input_container_ek2);
//		input_container_ek3 = (View) findViewById(R.id.input_container_ek3);
		placeholder_ek3 = (TextView) findViewById(R.id.placeholder_ek3);
//		button_container_ek5 = (View) findViewById(R.id.button_container_ek5);
		button_ek5 = (TextView) findViewById(R.id.button_ek5);
		_already_have_an_account__login = (TextView) findViewById(R.id._already_have_an_account__login);
	
		
		_already_have_an_account__login.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), login_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);


		});

		vector_ek1.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), get_started_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);


		});


		button_ek5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				registerNewUser();
			}
		});
	}

	private void registerNewUser()
	{


		// Take the value of two edit texts in Strings
		String email, password;
		email = placeholder_ek1.getText().toString();
		password = placeholder_ek3.getText().toString();

		// Validations for input email and password
		if (TextUtils.isEmpty(email)) {
			Toast.makeText(getApplicationContext(),
							"Please enter email!!",
							Toast.LENGTH_LONG)
					.show();
			return;
		}
		if (TextUtils.isEmpty(password)) {
			Toast.makeText(getApplicationContext(),
							"Please enter password!!",
							Toast.LENGTH_LONG)
					.show();
			return;
		}

		// create new user or register new user
		mAuth
				.createUserWithEmailAndPassword(email, password)
				.addOnCompleteListener(new OnCompleteListener<AuthResult>() {

					@Override
					public void onComplete(@NonNull Task<AuthResult> task)
					{
						if (task.isSuccessful()) {
							Toast.makeText(getApplicationContext(),
											"Registration successful!",
											Toast.LENGTH_LONG)
									.show();

							// if the user created intent to login activity
							Intent intent
									= new Intent(register_activity.this,
									Profile.class);
							startActivity(intent);
							overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
						}
						else {

							// Registration failed
							Toast.makeText(
											getApplicationContext(),
											"Registration failed!!"
													+ " Please try again later",
											Toast.LENGTH_LONG)
									.show();

						}
					}
				});

//		vector_ek2.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//
//				Intent nextScreen = new Intent(getApplicationContext(), get_started_activity.class);
//				startActivity(nextScreen);
//
//
//			}
//		});
//

	}
}
	
	