package com.codewithharry.shayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Display;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codewithharry.shayari.Adapters.AdapterMotivational;
import com.codewithharry.shayari.Adapters.AdapterRomantic;
import com.codewithharry.shayari.models.ModelMotivational;
import com.codewithharry.shayari.models.ModelRomantic;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RomanticActivity extends AppCompatActivity {

    ArrayList<ModelRomantic> romanticData= new ArrayList<>();

    private ProgressBar progressBar_romantic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romantic);

        progressBar_romantic= findViewById(R.id.progress_romantic);

        FirebaseDatabase romantic_firebase_data= FirebaseDatabase.getInstance();
        DatabaseReference romantic_firebase_datareference= romantic_firebase_data.getReference("romanticShayari");

        romantic_firebase_datareference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){
                    for (DataSnapshot snap :
                            snapshot.getChildren()) {
                        ModelRomantic modelRomantic1= new ModelRomantic(snap.getValue().toString());
                        romanticData.add(modelRomantic1);

                        RecyclerView recyclerView= findViewById(R.id.recyclerView_romantic);
                        LinearLayoutManager layoutManager_romantic= new LinearLayoutManager(getApplicationContext());
                        AdapterRomantic adapterRomantic= new AdapterRomantic(romanticData, getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager_romantic);
                        recyclerView.setAdapter(adapterRomantic);

                        progressBar_romantic.setVisibility(View.GONE);

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(RomanticActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}