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

import com.codewithharry.shayari.R;
import com.codewithharry.shayari.models.ModelLife;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterLife extends RecyclerView.Adapter<AdapterLife.viewHolderLife> {

    ArrayList<ModelLife> lifeData;
    Context context_life;

    public AdapterLife(ArrayList<ModelLife> lifeData, Context context_life) {
        this.lifeData = lifeData;
        this.context_life = context_life;
    }

    @NonNull
    @Override
    public viewHolderLife onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_life_design, parent, false);
        return new viewHolderLife(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderLife holder, int position) {

        holder.shayariText.setText(lifeData.get(position).getShayari_life());

        holder.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context_life.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", lifeData.get(position).getShayari_life());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context_life, "Copied", Toast.LENGTH_SHORT).show();
            }
        });

        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lifeIntent= new Intent(Intent.ACTION_SEND);
                lifeIntent.setType("text/plain");
                lifeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                lifeIntent.putExtra(Intent.EXTRA_TEXT, lifeData.get(position).getShayari_life());
                context_life.startActivity(lifeIntent);
            }
        });

        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context_life, "Added To Favorite", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lifeData.size();
    }

    public class viewHolderLife extends RecyclerView.ViewHolder {
        TextView shayariText;
        Button copyBtn, shareBtn, favBtn;
        public viewHolderLife(@NonNull View itemView) {
            super(itemView);
            shayariText= itemView.findViewById(R.id.shayari_life);
            copyBtn= itemView.findViewById(R.id.copyBtn_life);
            shareBtn= itemView.findViewById(R.id.shareBtn_life);
            favBtn= itemView.findViewById(R.id.fav_Btn_life);
        }
    }
}
