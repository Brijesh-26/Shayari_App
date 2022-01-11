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
import com.codewithharry.shayari.Adapters.AdapterWine;
import com.codewithharry.shayari.models.ModelLife;
import com.codewithharry.shayari.models.ModelWine;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WineActivity extends AppCompatActivity {


    ArrayList<ModelWine> wineData= new ArrayList<>();
    private ProgressBar progressBar_wine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);

        progressBar_wine =findViewById(R.id.progress_wine);
        FirebaseDatabase wine_firebase_data= FirebaseDatabase.getInstance();
        DatabaseReference wine_firebase_dataReference= wine_firebase_data.getReference("wineShayari");

        wine_firebase_dataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot snap :
                            snapshot.getChildren()) {

                        ModelWine modelWine1= new ModelWine(snap.getValue().toString());
                        wineData.add(modelWine1);

                        RecyclerView recyclerView= findViewById(R.id.recyclerView_wine);
                        LinearLayoutManager layoutManager_wine= new LinearLayoutManager(getApplicationContext());

                        AdapterWine adapterWine= new AdapterWine(wineData, getApplicationContext());

                        recyclerView.setLayoutManager(layoutManager_wine);
                        recyclerView.setAdapter(adapterWine);

                        progressBar_wine.setVisibility(View.GONE);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(WineActivity.this, "Error...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}