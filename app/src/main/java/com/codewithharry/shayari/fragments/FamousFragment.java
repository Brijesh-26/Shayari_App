package com.codewithharry.shayari.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codewithharry.shayari.R;


public class FamousFragment extends Fragment {
//    TextView textView;
//    RecyclerView recyclerView_main;
//    AdapterFamous adapterFamous;

    public FamousFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_famous, container, false);

//        recyclerView_main= view.findViewById(R.id.recyclerView_main);
//
////        textView= view.findViewById(R.id.text_ex);
////        Animation anim= new AlphaAnimation(0.0f, 1.0f);
////        anim.setDuration(860);
////        anim.setStartOffset(10);
////        anim.setRepeatMode(Animation.REVERSE);
////        anim.setRepeatCount(Animation.INFINITE);
////        textView.startAnimation(anim);
//
//
//        // SETTING NESTED ADAPTER
//
//        ArrayList<ModelFamous> arrayListVertical= null;
//
//        ArrayList<ModelHorizontalFamous> arrayListHorizontal = null;
//
////
//        ModelHorizontalFamous mo1= new ModelHorizontalFamous(R.drawable.amir, "brijesh kumar");
//
//        arrayListHorizontal.add(mo1);
////
//        ModelHorizontalFamous mo2= new ModelHorizontalFamous(R.drawable.ada, "Ada jafri");
//        arrayListHorizontal.add(mo2);
////
//        ModelHorizontalFamous mo3= new ModelHorizontalFamous(R.drawable.faiz, "Faiz");
//        arrayListHorizontal.add(mo3);
////
////        ModelFamous m1= new ModelFamous("Trending", (ArrayList<ModelHorizontalFamous>) arrayListHorizontal);
////        arrayListVertical.add(m1);
//
//        ModelFamous m2= new ModelFamous("brijesh", arrayListHorizontal);
//        arrayListVertical.add(m2);
////
////
//
////
//        recyclerView_main.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
////
//        adapterFamous= new AdapterFamous(getContext(), arrayListVertical);
//        recyclerView_main.setAdapter(adapterFamous);

        return view;
    }


}



















