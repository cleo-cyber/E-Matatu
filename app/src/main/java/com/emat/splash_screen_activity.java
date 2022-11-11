
package com.emat;

import android.app.Activity;
import android.os.Bundle;


import android.os.Handler;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splash_screen_activity extends Activity {

	
	private View __bg__splash_screen_ek2;
	private TextView e_mat_ek1;
	private TextView text_ek1;
	private FirebaseAuth mFirebaseAuth;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		mFirebaseAuth=FirebaseAuth.getInstance();

		FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
		if(mFirebaseUser!=null){

		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(splash_screen_activity.this,MainActivity.class));
			finish();
			}
		},2500);}
		else{

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					startActivity(new Intent(splash_screen_activity.this,onboarding_1_activity.class));
					finish();
				}
			},2500);}

		}


	}
	
	