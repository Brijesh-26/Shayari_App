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
import com.codewithharry.shayari.models.ModelPatriotic;

import java.util.ArrayList;

public class AdapterPatriotic extends RecyclerView.Adapter<AdapterPatriotic.viewHolderPatriotic> {

    ArrayList<ModelPatriotic> patrioticData;
    Context context_patriotic;

    public AdapterPatriotic(ArrayList<ModelPatriotic> patrioticData, Context context_patriotic) {
        this.patrioticData = patrioticData;
        this.context_patriotic = context_patriotic;
    }

    @NonNull
    @Override
    public viewHolderPatriotic onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_patriotic_design, parent, false);
        return new viewHolderPatriotic(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderPatriotic holder, int position) {

        holder.shayariText.setText(patrioticData.get(position).getShayari_patriotic());
        holder.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context_patriotic.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", patrioticData.get(position).getShayari_patriotic());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context_patriotic, "Copied", Toast.LENGTH_SHORT).show();
            }
        });

        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent patrioticIntent= new Intent(Intent.ACTION_SEND);
                patrioticIntent.setType("text/plain");
                patrioticIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                patrioticIntent.putExtra(Intent.EXTRA_TEXT, patrioticData.get(position).getShayari_patriotic());
                context_patriotic.startActivity(patrioticIntent);
            }
        });

        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context_patriotic, "Added To Favorite", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return patrioticData.size();
    }

    public class viewHolderPatriotic extends RecyclerView.ViewHolder {
        TextView shayariText;
        Button copyBtn, shareBtn, favBtn;
        public viewHolderPatriotic(@NonNull View itemView) {
            super(itemView);
            shayariText= itemView.findViewById(R.id.shayari_patriotic);
            copyBtn= itemView.findViewById(R.id.copyBtn_patriotic);
            shareBtn= itemView.findViewById(R.id.shareBtn_patriotic);
            favBtn= itemView.findViewById(R.id.fav_Btn_patriotic);
        }
    }
}
