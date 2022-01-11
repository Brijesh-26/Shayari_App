package com.codewithharry.shayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codewithharry.shayari.Adapters.AdapterLife;
import com.codewithharry.shayari.Adapters.AdapterMotivational;
import com.codewithharry.shayari.models.ModelLife;
import com.codewithharry.shayari.models.ModelMotivational;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LifeActivity extends AppCompatActivity {

    ArrayList<ModelLife> lifeData= new ArrayList<>();
    private ProgressBar progressBar_life;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);

        progressBar_life =findViewById(R.id.progressBar_life);
        FirebaseDatabase life_firebase_data= FirebaseDatabase.getInstance();
        DatabaseReference life_firebase_dataReference= life_firebase_data.getReference("lifeShayari");

        life_firebase_dataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot snap :
                            snapshot.getChildren()) {
                        ModelLife modelLife1= new ModelLife(snap.getValue().toString());
                        lifeData.add(modelLife1);

                        RecyclerView recyclerView= findViewById(R.id.recyclerView_life);
                        LinearLayoutManager layoutManager_life= new LinearLayoutManager(getApplicationContext());
                        AdapterLife adapterLife= new AdapterLife(lifeData, getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager_life);
                        recyclerView.setAdapter(adapterLife);

                        progressBar_life.setVisibility(View.GONE);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(LifeActivity.this, "Error...", Toast.LENGTH_SHORT).show();
            }
        });

    }
}