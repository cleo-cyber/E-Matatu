package com.emat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Profile extends AppCompatActivity {
    String name;
    String email;
    int PhoneNumber;
    String Destination;
    String PickUpPoint;

    private  EditText nameInput;
    private EditText emailInput;
    private EditText phoneNumberInput;
    private EditText destinationInput;
    private EditText pickUpPointInput;
    private ProgressBar loadingPB;

    private Button editButton;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root=db.getReference().child("UserProfile");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);




        nameInput = (EditText) findViewById(R.id.fullname);
        emailInput= (EditText) findViewById(R.id.emailaddress);
        phoneNumberInput= (EditText) findViewById(R.id.phone);
        destinationInput= (EditText) findViewById(R.id.destination);
        pickUpPointInput= (EditText) findViewById(R.id.pickup);
        loadingPB = (ProgressBar) findViewById(R.id.loading);


        editButton = (Button) findViewById(R.id.editprof);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);
                name=nameInput.getText().toString();
                email=emailInput.getText().toString();
                Destination=destinationInput.getText().toString();
                PickUpPoint=pickUpPointInput.getText().toString();
                PhoneNumber=Integer.parseInt(phoneNumberInput.getText().toString());

                UserRVmodel userRVmodel= new UserRVmodel(name,email,PhoneNumber,Destination,PickUpPoint);
                root.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadingPB.setVisibility(View.GONE);
                        root.child("UserProfile").setValue(userRVmodel);
                        Toast.makeText(Profile.this,"Update successful",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Profile.this,MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Profile.this,"Failed update",Toast.LENGTH_SHORT).show();
                    }
                });

//                if(name.length()==0){
//                    nameInput.setError("Please enter name");
//                }else if(email.length()==0){
//                    emailInput.setError("Please enter email");
//                }else if(Destination.length()==0){
//                    destinationInput.setError("Please enter destination");
//                }else if(PickUpPoint.length()==0){
//                    pickUpPointInput.setError("Please enter pickup point");
//                }
//                else{
//                    HashMap<String,String > userProfile=new HashMap<>();
//                    userProfile.put("name",name);
//                    userProfile.put("email",email);
//                    userProfile.put("destination",Destination);
//                    userProfile.put("pickup",PickUpPoint);
//                    userProfile.put("phone",String.valueOf(PhoneNumber));
//
//                    root.push().setValue(userProfile).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            Toast.makeText(Profile.this,"Updated",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//






            }
        });


    }


}