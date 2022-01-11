package com.codewithharry.shayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codewithharry.shayari.Adapters.AdapterMotivational;
import com.codewithharry.shayari.models.ModelMotivational;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MotivationalActivity extends AppCompatActivity {


    ArrayList<ModelMotivational> motivaionalData= new ArrayList<>();
    private ProgressBar progressBar_motivational;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational);

        progressBar_motivational= findViewById(R.id.progress_motivational);

        FirebaseDatabase motivational_firebase_data= FirebaseDatabase.getInstance();
        DatabaseReference motivational_firebase_dataReference= motivational_firebase_data.getReference("motivationalShayari");

        motivational_firebase_dataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){
                    for (DataSnapshot snap :
                            snapshot.getChildren()) {
                        ModelMotivational modelMotivational1= new ModelMotivational(snap.getValue().toString());
                        motivaionalData.add(modelMotivational1);

                        RecyclerView recyclerView= findViewById(R.id.recyclerView_motivational);
                        LinearLayoutManager layoutManager_motivational= new LinearLayoutManager(getApplicationContext());
                        AdapterMotivational adapterMotivational= new AdapterMotivational(motivaionalData, getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager_motivational);
                        recyclerView.setAdapter(adapterMotivational);
                        
                        progressBar_motivational.setVisibility(View.GONE);
                        
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(MotivationalActivity.this, "Error...", Toast.LENGTH_SHORT).show();
            }
        });



    }
}