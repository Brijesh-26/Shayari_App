package com.codewithharry.shayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codewithharry.shayari.Adapters.AdapterBreakup;
import com.codewithharry.shayari.Adapters.AdapterMotivational;
import com.codewithharry.shayari.models.ModelBreakup;
import com.codewithharry.shayari.models.ModelMotivational;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BreakupActivity extends AppCompatActivity {

    ArrayList<ModelBreakup> breakupData= new ArrayList<>();
    private ProgressBar progressBar_breakup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakup);

        progressBar_breakup= findViewById(R.id.progress_breakup);

        FirebaseDatabase breakup_firebase_data= FirebaseDatabase.getInstance();
        DatabaseReference breakup_firebase_dataReference= breakup_firebase_data.getReference("brokenShayari");

        breakup_firebase_dataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot snap :
                            snapshot.getChildren()) {

                        ModelBreakup modelBreakup1= new ModelBreakup(snap.getValue().toString());
                        breakupData.add(modelBreakup1);


                        RecyclerView recyclerView= findViewById(R.id.recyclerView_breakup);
                        LinearLayoutManager layoutManager_breakup= new LinearLayoutManager(getApplicationContext());

                        AdapterBreakup adapterBreakup= new AdapterBreakup(breakupData, getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager_breakup);
                        recyclerView.setAdapter(adapterBreakup);




                        progressBar_breakup.setVisibility(View.GONE);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(BreakupActivity.this, "Error...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}