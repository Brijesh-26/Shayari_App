package com.codewithharry.shayari.Adapters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.codewithharry.shayari.R;
import com.codewithharry.shayari.models.ModelWine;

import java.util.ArrayList;

public class AdapterWine extends RecyclerView.Adapter<AdapterWine.viewHolderWine> {

    ArrayList<ModelWine> wineData;
    Context context_wine;

    public AdapterWine(ArrayList<ModelWine> wineData, Context context_wine) {
        this.wineData = wineData;
        this.context_wine = context_wine;
    }

    @NonNull
    @Override
    public viewHolderWine onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wine_design, parent, false);
        return new viewHolderWine(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderWine holder, int position) {

        holder.shayariText.setText(wineData.get(position).getShayari_wine());

        holder.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context_wine.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", wineData.get(position).getShayari_wine());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context_wine, "Copied", Toast.LENGTH_SHORT).show();
            }
        });

        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context_wine, "Added To Favorite", Toast.LENGTH_SHORT).show();
            }
        });

        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wineIntent= new Intent(Intent.ACTION_SEND);
                wineIntent.setType("text/plain");
                wineIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                wineIntent.putExtra(Intent.EXTRA_TEXT, wineData.get(position).getShayari_wine());
                context_wine.startActivity(wineIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return wineData.size();
    }

    public class viewHolderWine extends RecyclerView.ViewHolder {
        TextView shayariText;
        Button copyBtn, shareBtn, favBtn;
        public viewHolderWine(@NonNull View itemView) {
            super(itemView);
            shayariText= itemView.findViewById(R.id.shayari_wine);
            copyBtn= itemView.findViewById(R.id.copyBtn_wine);
            shareBtn= itemView.findViewById(R.id.shareBtn_wine);
            favBtn= itemView.findViewById(R.id.fav_Btn_wine);
        }
    }
}
