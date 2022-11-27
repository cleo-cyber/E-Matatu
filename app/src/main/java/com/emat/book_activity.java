package com.emat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class book_activity extends Activity {
	private FirebaseDatabase db= FirebaseDatabase.getInstance();
	private DatabaseReference root=db.getReference().child("Bookings");
	private DatabaseReference mroot=db.getReference().child("UserProfile");
	private DatabaseReference pay=db.getReference().child("Payment");
	SmsManager smsManager;
	TextView pick,drop,veh,pri,book;
	@SuppressLint("MissingInflatedId")
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.book);

		Spinner pickup=(Spinner) findViewById(R.id.input_container_ek3);
		Spinner dropoff=(Spinner)findViewById(R.id.input_container_ek2);
		Spinner vehicle=(Spinner)findViewById(R.id.vehicle_regist_);
		Spinner dep_time=(Spinner)findViewById(R.id.input_container_ek1);


		TextView confirm =  findViewById(R.id.button);
		pick=findViewById(R.id.pick);
		drop=(TextView) findViewById(R.id.drop);
		veh=(TextView) findViewById(R.id.veh);
		pri=(TextView) findViewById(R.id.pri);
		book=(TextView) findViewById(R.id.book);

		smsManager=SmsManager.getDefault();

		getDefaultBooking();
		book.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				confirmBooking();
			}
		});
		//PICKUP
		ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.pickup_points, android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		pickup.setAdapter(adapter);

		//DROPOFF
		ArrayAdapter<CharSequence> dropoffadapter=ArrayAdapter.createFromResource(this, R.array.dropoff_points, android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		dropoff.setAdapter(dropoffadapter);

		//VEHICLE
		ArrayAdapter<CharSequence> vehicleadapter=ArrayAdapter.createFromResource(this, R.array.Vehicles, android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		vehicle.setAdapter(vehicleadapter);

		//Departure time
		ArrayAdapter<CharSequence> dep_timeadapter=ArrayAdapter.createFromResource(this, R.array.departure_time, android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		dep_time.setAdapter(dep_timeadapter);

		confirm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				String pickpoint = pickup.getSelectedItem().toString();
				String Drop=dropoff.getSelectedItem().toString();
				String vehicl = vehicle.getSelectedItem().toString();
				String dept=dep_time.getSelectedItem().toString();

				HashMap<String,Object> bookings=new HashMap<>();
				bookings.put("pickuppoint",pickpoint);
				bookings.put("DropPoint",Drop);
				bookings.put("Vehicle",vehicl);
				bookings.put("Departure Time",dept);
				root.setValue(bookings);
				Intent intent=new Intent(book_activity.this,seat_activity.class);
				startActivity(intent);
			}
		});


//		back.setOnClickListener(v->{
//			Intent back = new Intent(this, MainActivity.class);
//			startActivity(back);
//			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//
//
//		});

	
	}

	private void confirmBooking() {
		Intent intent= new Intent(book_activity.this,EditProfile.class);
		startActivity(intent);

		Toast.makeText(this, "Booking Successful", Toast.LENGTH_SHORT).show();
	}

	private void getDefaultBooking() {
		mroot.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot snapshot) {
				String pickUpPoint=snapshot.child("PickUpPoint").getValue(String.class);
				String Email=snapshot.child("email").getValue(String.class);
				String Destination=snapshot.child("Destination").getValue(String.class);

				drop.setText(Destination);
				pick.setText(pickUpPoint);
			}

			@Override
			public void onCancelled(@NonNull DatabaseError error) {

			}
		});
		pay.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot snapshot) {
				String amount= snapshot.child("Amount").getValue(String.class);
				pri.setText(amount);
			}

			@Override
			public void onCancelled(@NonNull DatabaseError error) {

			}
		});


	}
}
	
	