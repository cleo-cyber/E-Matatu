package com.emat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class EditProfile extends AppCompatActivity {


    private EditText nameInput;
    private EditText emailInput;
    private EditText phoneNumberInput;
    private EditText destinationInput;
    private EditText pickUpPointInput;
    private ProgressBar loadingPB;

    private Button editButton,deleteBtn;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();

    private UserRVmodel userRVmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        nameInput = (EditText) findViewById(R.id.fullname);
        emailInput= (EditText) findViewById(R.id.emailaddress);
        phoneNumberInput= (EditText) findViewById(R.id.phone);
        destinationInput= (EditText) findViewById(R.id.destination);
        pickUpPointInput= (EditText) findViewById(R.id.pickup);
        loadingPB = (ProgressBar) findViewById(R.id.loading);

        userRVmodel=getIntent().getParcelableExtra("name");

        if (userRVmodel!=null){
            nameInput.setText(userRVmodel.getName());
            emailInput.setText(userRVmodel.getEmail());
            phoneNumberInput.setText(userRVmodel.getPhoneNumber());
            destinationInput.setText(userRVmodel.getDestination());
            pickUpPointInput.setText(userRVmodel.getPickUpPoint());
        }

        DatabaseReference root=db.getReference();
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);

                String name=nameInput.getText().toString();
                String email=emailInput.getText().toString();
                String Destination=destinationInput.getText().toString();
                String PickUpPoint=pickUpPointInput.getText().toString();
                int PhoneNumber=Integer.parseInt(phoneNumberInput.getText().toString());

                HashMap<String,Object> user=new HashMap<>();

                user.put("name",name);
                user.put("email",email);
                user.put("Destination",Destination);
                user.put("PhoneNumber",PhoneNumber);
                user.put("PickUpPoint",PickUpPoint);

                root.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadingPB.setVisibility(View.GONE);
                        root.updateChildren(user);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EditProfile.this, "Failed to update user", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}