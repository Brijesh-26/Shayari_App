package com.codewithharry.shayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codewithharry.shayari.Adapters.AdapterFriendship;
import com.codewithharry.shayari.Adapters.AdapterRomantic;
import com.codewithharry.shayari.models.ModelFriendship;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FriendshipActivity extends AppCompatActivity {

    ArrayList<ModelFriendship> friendshipData= new ArrayList<>();

    private ProgressBar progressBar_friendship;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendship);

        progressBar_friendship= findViewById(R.id.progress_friendship);


        FirebaseDatabase friend_firebase_Data= FirebaseDatabase.getInstance();
        DatabaseReference friend_firebase_dataReference= friend_firebase_Data.getReference("friendshipShayari");

        friend_firebase_dataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    for (DataSnapshot snap :
                            snapshot.getChildren()) {


                        ModelFriendship modelFriendship1= new ModelFriendship(snap.getValue().toString());
                        friendshipData.add(modelFriendship1);


                        RecyclerView recyclerView= findViewById(R.id.recyclerView_friendship);
                        LinearLayoutManager layoutManager_friendship= new LinearLayoutManager(getApplicationContext());
                        AdapterFriendship adapterFriendship= new AdapterFriendship(friendshipData, getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager_friendship);
                        recyclerView.setAdapter(adapterFriendship);

                        progressBar_friendship.setVisibility(View.GONE);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(FriendshipActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}