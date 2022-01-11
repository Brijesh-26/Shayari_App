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

import com.codewithharry.shayari.R;
import com.codewithharry.shayari.models.ModelFunny;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFunny extends RecyclerView.Adapter<AdapterFunny.viewHolderFunny> {

    ArrayList<ModelFunny> funnyData;
    Context context_funny;

    public AdapterFunny(ArrayList<ModelFunny> funnyData, Context context_funny) {
        this.funnyData = funnyData;
        this.context_funny = context_funny;
    }

    @NonNull
    @Override
    public viewHolderFunny onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_funny_design, parent, false);
        return new viewHolderFunny(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderFunny holder, int position) {
        holder.shayariText.setText(funnyData.get(position).getShayari_funny());

        holder.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context_funny.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", funnyData.get(position).getShayari_funny());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context_funny, "Copied", Toast.LENGTH_SHORT).show();
            }
        });
        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent funnyIntent= new Intent(Intent.ACTION_SEND);
                funnyIntent.setType("text/plain");
                funnyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                funnyIntent.putExtra(Intent.EXTRA_TEXT, funnyData.get(position).getShayari_funny());
                context_funny.startActivity(funnyIntent);
            }
        });
        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context_funny, "Added To Favorite", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return funnyData.size();
    }

    public class viewHolderFunny extends RecyclerView.ViewHolder {
        TextView shayariText;
        Button copyBtn, shareBtn, favBtn;
        public viewHolderFunny(@NonNull View itemView) {
            super(itemView);
            shayariText= itemView.findViewById(R.id.shayari_funny);
            copyBtn= itemView.findViewById(R.id.copyBtn_funny);
            shareBtn= itemView.findViewById(R.id.shareBtn_funny);
            favBtn= itemView.findViewById(R.id.fav_Btn_funny);
        }
    }
}
