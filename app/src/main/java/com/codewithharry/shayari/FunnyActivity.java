package com.codewithharry.shayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codewithharry.shayari.Adapters.AdapterFunny;
import com.codewithharry.shayari.Adapters.AdapterLife;
import com.codewithharry.shayari.models.ModelFunny;
import com.codewithharry.shayari.models.ModelLife;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FunnyActivity extends AppCompatActivity {

    ArrayList<ModelFunny> funnyData= new ArrayList<>();
    private ProgressBar progressBar_funny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny);

        progressBar_funny= findViewById(R.id.progressBar_funny);
        FirebaseDatabase funny_firebase_data= FirebaseDatabase.getInstance();
        DatabaseReference funny_firebase_dataReference= funny_firebase_data.getReference("funnyShayari");

        funny_firebase_dataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot snap :
                            snapshot.getChildren()) {

                        ModelFunny modelFunny1= new ModelFunny(snap.getValue().toString());
                        funnyData.add(modelFunny1);

                        RecyclerView recyclerView= findViewById(R.id.recyclerView_funny);
                        LinearLayoutManager layoutManager_funny= new LinearLayoutManager(getApplicationContext());

                        AdapterFunny adapterFunny= new AdapterFunny(funnyData, getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager_funny);
                        recyclerView.setAdapter(adapterFunny);
                        progressBar_funny.setVisibility(View.GONE);


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(FunnyActivity.this, "Error...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}