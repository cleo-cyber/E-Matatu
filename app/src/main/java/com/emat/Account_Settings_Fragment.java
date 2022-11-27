package com.emat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Account_Settings_Fragment extends Fragment {
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference root=db.getReference().child("UserProfile");

    private TextView username,DisplayEmail,PhoneDisplay,DestinationDisplay;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings,container,false);

        Button button = (Button) view.findViewById(R.id.edit_profile);

        username=(TextView) view.findViewById(R.id.user_name);
        DisplayEmail=(TextView) view.findViewById(R.id.display_mail);
        PhoneDisplay=(TextView) view.findViewById(R.id.phoneDisplay);
        DestinationDisplay=(TextView) view.findViewById(R.id.DestinationDisplay);

        getUser();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),EditProfile.class);
                startActivity(intent);
            }
        });
        return view;

    }
    private void getUser(){
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Username=snapshot.child("name").getValue(String.class);
                String Email=snapshot.child("email").getValue(String.class);
                String PhoneNumber=snapshot.child("PhoneNumber").getValue(String.class);
                String Destination=snapshot.child("Destination").getValue(String.class);


                username.setText(Username);
                DisplayEmail.setText(Email);
                PhoneDisplay.setText(PhoneNumber);
                DestinationDisplay.setText(Destination);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                ////
            }
        });
    }

}
