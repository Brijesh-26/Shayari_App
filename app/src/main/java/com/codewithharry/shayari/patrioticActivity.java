package com.codewithharry.shayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codewithharry.shayari.Adapters.AdapterPatriotic;
import com.codewithharry.shayari.Adapters.AdapterRomantic;
import com.codewithharry.shayari.models.ModelPatriotic;
import com.codewithharry.shayari.models.ModelRomantic;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class patrioticActivity extends AppCompatActivity {

    ArrayList<ModelPatriotic> patrioticData= new ArrayList<>();

    private ProgressBar progressBar_patriotic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patriotic);

        progressBar_patriotic= findViewById(R.id.progressBar_patriotic);

        FirebaseDatabase patriotic_firebase_data= FirebaseDatabase.getInstance();
        DatabaseReference patriotic_firebase_datareference= patriotic_firebase_data.getReference("patrioticShayari");

        patriotic_firebase_datareference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot snap :
                            snapshot.getChildren()) {
                        ModelPatriotic modelPatriotic1= new ModelPatriotic(snap.getValue().toString());
                        patrioticData.add(modelPatriotic1);

                        RecyclerView recyclerView= findViewById(R.id.recyclerView_patriotic);
                        LinearLayoutManager layoutManager_patriotic= new LinearLayoutManager(getApplicationContext());
                        AdapterPatriotic adapterPatriotic= new AdapterPatriotic(patrioticData, getApplicationContext());

                        recyclerView.setLayoutManager(layoutManager_patriotic);
                        recyclerView.setAdapter(adapterPatriotic);

                        progressBar_patriotic.setVisibility(View.GONE);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(patrioticActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}