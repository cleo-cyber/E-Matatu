
package com.emat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class register_activity extends Activity {


	private TextView placeholder_ek1;
	private TextView placeholder_ek3;
	private ImageView vector;
	private ImageView vector_ek1;


	private FirebaseAuth mAuth;

	@SuppressLint("MissingInflatedId")
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		mAuth = FirebaseAuth.getInstance();


		vector = (ImageView) findViewById(R.id.vector);
		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		placeholder_ek1 = (TextView) findViewById(R.id.placeholder_ek1);
		placeholder_ek3 = (TextView) findViewById(R.id.placeholder_ek3);
		TextView button_ek5 = (TextView) findViewById(R.id.button_ek5);
		TextView _already_have_an_account__login = (TextView) findViewById(R.id._already_have_an_account__login);


		_already_have_an_account__login.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), login_fail_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);


		});

		vector.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), get_started_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

		});

		vector_ek1.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), get_started_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);


		});


		button_ek5.setOnClickListener(v -> registerNewUser());
	}

	private void registerNewUser()
	{


		String email, password;
		email = placeholder_ek1.getText().toString();
		password = placeholder_ek3.getText().toString();

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

		mAuth
				.createUserWithEmailAndPassword(email, password)
				.addOnCompleteListener(task -> {
					if (task.isSuccessful()) {
						Toast.makeText(getApplicationContext(),
										"Registration successful!",
										Toast.LENGTH_LONG)
								.show();

						Intent intent
								= new Intent(register_activity.this,
								login_fail_activity.class);
						startActivity(intent);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
					}
					else {

						Toast.makeText(
										getApplicationContext(),
										"Registration failed!!"
												+ " Please try again later",
										Toast.LENGTH_LONG)
								.show();

					}
				});


	}
}
	
	