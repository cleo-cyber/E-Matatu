
package com.emat;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class login_fail_activity extends Activity {

	private FirebaseAuth mFirebaseAuth;
	private TextView password_input;
	private TextView email_input;
	private ImageView vector;
	private ImageView vector_ek1;

	private FirebaseAuth mAuth;

	@Override

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_fail);
		mAuth = FirebaseAuth.getInstance();
		email_input = (TextView) findViewById(R.id.input_container);
		password_input = (TextView) findViewById(R.id.input_container_ek1);



		TextView no_account = (TextView) findViewById(R.id._don_t_have_an_account__register);
		TextView forgot_password = (TextView) findViewById(R.id._forgot_password);
		TextView login = (TextView) findViewById(R.id.button);
		ImageView vector = (ImageView) findViewById(R.id.vector);
		ImageView vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);


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


		no_account.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), register_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


		});


		forgot_password.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), forgot_password_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


		});

		login.setOnClickListener(v -> loginUserAccount());
	}

	private void loginUserAccount()
	{

		// Take the value of two edit texts in Strings
		String email, password;
		email = email_input.getText().toString();
		password = password_input.getText().toString();

		// validations for input email and password
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

		mAuth.signInWithEmailAndPassword(email, password)
				.addOnCompleteListener(
						task -> {
							if (task.isSuccessful()) {
								Toast.makeText(getApplicationContext(),
												"Login successful!!",
												Toast.LENGTH_LONG)
										.show();

								Intent intent
										= new Intent(login_fail_activity.this,
										MainActivity.class);
								startActivity(intent);
								overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
							}

							else {

								Toast.makeText(getApplicationContext(),
												"Login failed!!",
												Toast.LENGTH_LONG)
										.show();

							}
						});



	}



}
	
	