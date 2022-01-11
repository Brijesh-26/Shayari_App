package com.codewithharry.shayari.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codewithharry.shayari.Adapters.AdapterHome;
import com.codewithharry.shayari.R;
import com.codewithharry.shayari.models.ModelHome;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView= view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<ModelHome> dataholder;
        dataholder= new ArrayList<>();



        ModelHome ob1= new ModelHome(R.mipmap.motivational_foreground, "Motivational");
        dataholder.add(ob1);

//        ModelHome ob2= new ModelHome(R.mipmap.sad_foreground, "Broken Heart");
//        dataholder.add(ob2);

        ModelHome ob3= new ModelHome(R.mipmap.romantic_foreground, "Romantic");
        dataholder.add(ob3);

        ModelHome ob4= new ModelHome(R.mipmap.friendship_foreground, "Friendship");
        dataholder.add(ob4);

        ModelHome ob5= new ModelHome(R.mipmap.life_foreground, "Life");
        dataholder.add(ob5);

//        ModelHome ob6= new ModelHome(R.mipmap.funny_foreground, "Funny");
//        dataholder.add(ob6);

        ModelHome ob7= new ModelHome(R.mipmap.wine_foreground, "Break-Up");
        dataholder.add(ob7);

        ModelHome ob8= new ModelHome(R.mipmap.birthday_foreground, "Birthday");
        dataholder.add(ob8);

        ModelHome ob9= new ModelHome(R.mipmap.patriotic_foreground, "Patriotic");
        dataholder.add(ob9);

        ModelHome ob10= new ModelHome(R.mipmap.broken_heart_foreground, "Broken Heart");
        dataholder.add(ob10);

        ModelHome ob11= new ModelHome(R.mipmap.funny_foreground, "Funny");
        dataholder.add(ob11);



        recyclerView.setAdapter(new AdapterHome(dataholder, getContext()));




        return view;

    }
}