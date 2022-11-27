package com.emat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
        editButton = (Button) findViewById(R.id.editprof);
        deleteBtn = (Button) findViewById(R.id.deleteprof);

        DatabaseReference root=db.getReference().child("UserProfile");
        userRVmodel=getIntent().getParcelableExtra("name");

        if (userRVmodel!=null){
            nameInput.setText(userRVmodel.getName());
            emailInput.setText(userRVmodel.getEmail());
            phoneNumberInput.setText(userRVmodel.getPhoneNumber());
            destinationInput.setText(userRVmodel.getDestination());
            pickUpPointInput.setText(userRVmodel.getPickUpPoint());
        }

//        EDIT PROFILE

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);


                String name=nameInput.getText().toString();
                String email=emailInput.getText().toString();
                String Destination=destinationInput.getText().toString();
                String PickUpPoint=pickUpPointInput.getText().toString();
                int PhoneNumber=Integer.parseInt(phoneNumberInput.getText().toString());

                HashMap<String,Object > userProfile=new HashMap<>();
                userProfile.put("name",name);
                userProfile.put("email",email);
                userProfile.put("Destination",Destination);
                userProfile.put("PickUpPoint",PickUpPoint);
                userProfile.put("PhoneNumber",String.valueOf(PhoneNumber));

                root.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadingPB.setVisibility(View.GONE);
                        root.updateChildren(userProfile);
                        Toast.makeText(EditProfile.this, " update successfully", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EditProfile.this, "Failed to update user", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

//        DELETE PROFILE

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditProfile.this);

                builder.setTitle("Delete Profile").setMessage("Are you sure you want to delete").setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                loadingPB.setVisibility(View.VISIBLE);

                                root.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        snapshot.getRef().removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(EditProfile.this,"Sucessfully deleted",Toast.LENGTH_SHORT).show();
                                                Intent intent= new Intent(EditProfile.this,Account_Settings_Fragment.class);
                                                startActivity(intent);
                                            }
                                        });
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        Toast.makeText(EditProfile.this, "Unable to complete request", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();


            }
        });
    }
}