package com.emat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class seat_activity extends Activity {
//	ImageView cancel=findViewById(R.id.image_2);
	private FirebaseDatabase db= FirebaseDatabase.getInstance();
	private DatabaseReference root=db.getReference().child("Bookings");

	private FirebaseDatabase data=FirebaseDatabase.getInstance();
	private DatabaseReference mroot=data.getReference().child("Seats");
	private DatabaseReference userProf=data.getReference().child("UserProfile");
	private SmsManager smsManager;

	TextView pickuppoint; //pick up point
	TextView dropoff; //drop off
	TextView vehicle; //vehicle
	TextView departure; //departure
	TextView seat; //seat-number
	TextView price; //Price

	Button confirm;
	TextView submit;

	@SuppressLint("MissingInflatedId")
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.seat);

		Spinner row=findViewById(R.id.rectangle_4);
		Spinner column=findViewById(R.id.rectangle_4_ek1);
		confirm = (Button) findViewById(R.id.button2);
		pickuppoint=findViewById(R.id.pickup_point__ek1);
		dropoff=findViewById(R.id.destination2);
		vehicle=findViewById(R.id.reg);
		departure=findViewById(R.id.dept);
		seat=findViewById(R.id.seat);
		price=findViewById(R.id.price);
		submit = findViewById(R.id.confirm);


		smsManager=SmsManager.getDefault();

		ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Row_number, android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		row.setAdapter(adapter);

		ArrayAdapter<CharSequence> columnadapter=ArrayAdapter.createFromResource(this, R.array.Column_number, android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		column.setAdapter(columnadapter);
		getDetails();
		confirm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String roh = row.getSelectedItem().toString();
				String col=column.getSelectedItem().toString();

				HashMap<String,Object> seatie=new HashMap<>();

				seatie.put("Row",roh);
				seatie.put("Column",col);
				mroot.setValue(seatie);


			}
		});
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mroot.addValueEventListener(new ValueEventListener() {
					@Override
					public void onDataChange(@NonNull DataSnapshot snapshot) {
						String row=snapshot.child("Row").getValue(String.class);
						String column=snapshot.child("Column").getValue(String.class);
						String SeatNumber=row+column;
						String reg= snapshot.child("Vehicle").getValue(String.class);
						smsManager.sendTextMessage("+254768350329",null,"Your travelling details are as follows:Vehicle:"+reg+"\nSeat number"+SeatNumber ,null,null);
						Toast.makeText(seat_activity.this, "Sucessfull booking", Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onCancelled(@NonNull DatabaseError error) {

					}
				});
			}
		});
//		cancel.setOnClickListener(v -> {
//			Intent intent=new Intent(this, book_activity.class );
//			startActivity(intent);
//			overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
//
//		});








	}

	private void getDetails() {
		root.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot snapshot) {
				String pickup=snapshot.child("pickuppoint").getValue(String.class);
				String drop=snapshot.child("DropPoint").getValue(String.class);
				String vehc=snapshot.child("vehicle").getValue(String.class);
				String time=snapshot.child("Departure Time").getValue(String.class);

				pickuppoint.setText(pickup);
				dropoff.setText(drop);
				vehicle.setText(vehc);
				departure.setText(time);
			}

			@Override
			public void onCancelled(@NonNull DatabaseError error) {

			}
		});
	mroot.addValueEventListener(new ValueEventListener() {
		@Override
		public void onDataChange(@NonNull DataSnapshot snapshot) {
			String row=snapshot.child("Row").getValue(String.class);
			String column=snapshot.child("Column").getValue(String.class);
			String SeatNumber=row+column;
			String reg= snapshot.child("Vehicle").getValue(String.class);
			seat.setText(SeatNumber);

		}

		@Override
		public void onCancelled(@NonNull DatabaseError error) {

		}
	});
	}

}
	
	