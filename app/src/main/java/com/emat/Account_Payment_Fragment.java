package com.emat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Account_Payment_Fragment extends Fragment  {
    EditText addFunds;
    Button button;
    TextView Ecash;
    SmsManager smsManager;
    FirebaseDatabase db= FirebaseDatabase.getInstance();
    DatabaseReference root= db.getReference().child("Payment");
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.payment_fragment, container, false);

        button = (Button) view.findViewById(R.id.addfunds);
        Ecash =  (TextView) view.findViewById(R.id.cashholder);
        smsManager=SmsManager.getDefault();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());

              View mview=getLayoutInflater().inflate(R.layout.fundsdialogue,null);
              addFunds= (EditText) mview.findViewById(R.id.amount);
              builder.setTitle("Add Fund")
                      .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {

                            int funds= Integer.parseInt(addFunds.getText().toString());
                            HashMap<String,String> map = new HashMap<>();
                            map.put("Amount", String.valueOf(funds));
                            root.setValue(map);




                          }
                      }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              Toast.makeText(getActivity(), "Failed to add funds", Toast.LENGTH_SHORT).show();
                          }
                      })
              ;
                builder.setView(mview);
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        getAmount();

        return view;

    }

    private void getAmount() {

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String amount= snapshot.child("Amount").getValue(String.class);
                Ecash.setText("KES:"+ amount);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }





}

