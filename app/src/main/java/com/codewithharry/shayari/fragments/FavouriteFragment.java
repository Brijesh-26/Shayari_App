package com.codewithharry.shayari.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.codewithharry.shayari.R;



public class FavouriteFragment extends Fragment {

   TextView textView;

    public FavouriteFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_favourite, container, false);


        textView= view.findViewById(R.id.textView_favorite);
        Animation anim= new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(860);
        anim.setStartOffset(10);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        textView.startAnimation(anim);


        return view;
    }
}