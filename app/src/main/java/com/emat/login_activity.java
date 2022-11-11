
package com.emat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class login_activity extends Activity {


	private TextView placeholder_ek4;
	private TextView placeholder_ek5;


    private FirebaseAuth mAuth;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);


		mAuth = FirebaseAuth.getInstance();


        findViewById(R.id.vector_ek4);
		placeholder_ek4 = findViewById(R.id.placeholder_ek4);
		placeholder_ek5 = findViewById(R.id.placeholder_ek5);
        ImageView vector_ek5 = findViewById(R.id.vector_ek5);
		TextView _don_t_have_an_account__register = findViewById(R.id._don_t_have_an_account__register);
		TextView _forgot_password = findViewById(R.id._forgot_password);
        TextView button_ek6 = findViewById(R.id.button_ek6);
	
		
		_don_t_have_an_account__register.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), register_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


		});

		vector_ek5.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), get_started_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

		});
		
		
		_forgot_password.setOnClickListener(v -> {

			Intent nextScreen = new Intent(getApplicationContext(), forgot_password_activity.class);
			startActivity(nextScreen);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

		});

		button_ek6.setOnClickListener(v -> loginUserAccount());
	}

	private void loginUserAccount()
	{

		// Take the value of two edit texts in Strings
		String email, password;
		email = placeholder_ek4.getText().toString();
		password = placeholder_ek5.getText().toString();

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

								// if sign-in is successful
								// intent to home activity
								Intent intent
										= new Intent(login_activity.this,
										MainActivity.class);
								startActivity(intent);
								overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
							}

							else {

								// sign-in failed
								Toast.makeText(getApplicationContext(),
												"Login failed!!",
												Toast.LENGTH_LONG)
										.show();

							}
						});
		
		

	}
}
	
	