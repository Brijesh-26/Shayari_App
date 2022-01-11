package com.codewithharry.shayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.codewithharry.shayari.databinding.ActivityMainBinding;
import com.codewithharry.shayari.fragments.FamousFragment;
import com.codewithharry.shayari.fragments.FavouriteFragment;
import com.codewithharry.shayari.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;

public class MainActivity extends AppCompatActivity {



    ActivityMainBinding binding;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

//        button= findViewById(R.id.share);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(Intent.ACTION_SEND);
//                intent.setType("text/plain");
//                intent.putExtra(Intent.EXTRA_SUBJECT, "")
//            }
//        });

        FragmentTransaction hometrans= getSupportFragmentManager().beginTransaction();
        hometrans.replace(R.id.content, new HomeFragment());
        hometrans.commit();

        binding.bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        FragmentTransaction hometrans= getSupportFragmentManager().beginTransaction();
                        hometrans.replace(R.id.content, new HomeFragment());
                        hometrans.commit();
                        break;

                    case R.id.favourite:
                        FragmentTransaction favtrans= getSupportFragmentManager().beginTransaction();
                        favtrans.replace(R.id.content, new FavouriteFragment());
                        favtrans.commit();
                        break;

                    case R.id.famous:
                        FragmentTransaction famtrans= getSupportFragmentManager().beginTransaction();
                        famtrans.replace(R.id.content, new FamousFragment());
                        famtrans.commit();
                        break;


                }
                return true;
            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (item.getItemId()== R.id.share){
            ApplicationInfo api= getApplicationContext().getApplicationInfo();
            String apkpath= api.sourceDir;


            Intent intent= new Intent(Intent.ACTION_SEND);
            intent.setType("application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkpath)));
            startActivity(intent);


        }
        return true;
    }
}