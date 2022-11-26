package com.emat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class book_activity extends Activity {
	private FirebaseDatabase db= FirebaseDatabase.getInstance();
	private DatabaseReference root=db.getReference().child("Bookings");
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.book);

		Spinner pickup=(Spinner) findViewById(R.id.input_container_ek3);
		Spinner dropoff=(Spinner)findViewById(R.id.input_container_ek2);
		Spinner vehicle=(Spinner)findViewById(R.id.vehicle_regist_);
		Spinner dep_time=(Spinner)findViewById(R.id.input_container_ek1);
		TextView confirm =  findViewById(R.id.button);

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
}
	
	