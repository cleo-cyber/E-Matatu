
package com.emat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splash_screen_activity extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();

		FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
		if(mFirebaseUser!=null){

		
		new Handler().postDelayed(() -> {
			startActivity(new Intent(splash_screen_activity.this,MainActivity.class));
		finish();
		},2500);}
		else{

			new Handler().postDelayed(() -> {
				startActivity(new Intent(splash_screen_activity.this,onboarding_1_activity.class));
				finish();
			},2500);}

		}


	}
	
	