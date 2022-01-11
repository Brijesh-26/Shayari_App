package com.codewithharry.shayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codewithharry.shayari.Adapters.AdapterBirthday;
import com.codewithharry.shayari.Adapters.AdapterLife;
import com.codewithharry.shayari.models.ModelBirthday;
import com.codewithharry.shayari.models.ModelLife;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BirthdayActivity extends AppCompatActivity {

    ArrayList<ModelBirthday> birthdayData= new ArrayList<>();
    private ProgressBar progressBar_birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

        progressBar_birthday= findViewById(R.id.progressBar_birthday);

        FirebaseDatabase birthday_firebase_data= FirebaseDatabase.getInstance();
        DatabaseReference birthday_firebase_dataReference= birthday_firebase_data.getReference("birthdayShayari");


        birthday_firebase_dataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot snap :
                            snapshot.getChildren()) {

                        ModelBirthday modelBirthday1= new ModelBirthday(snap.getValue().toString());
                        birthdayData.add(modelBirthday1);


                        RecyclerView recyclerView= findViewById(R.id.recyclerView_birthday);
                        LinearLayoutManager layoutManager_birthday= new LinearLayoutManager(getApplicationContext());
                        AdapterBirthday adapterBirthday= new AdapterBirthday(birthdayData, getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager_birthday);
                        recyclerView.setAdapter(adapterBirthday);

                        progressBar_birthday.setVisibility(View.GONE);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(BirthdayActivity.this, "Error...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}