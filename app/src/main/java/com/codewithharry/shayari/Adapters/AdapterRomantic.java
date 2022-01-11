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
import com.codewithharry.shayari.models.ModelRomantic;

import java.util.ArrayList;

public class AdapterRomantic extends RecyclerView.Adapter<AdapterRomantic.viewHolderRomantic> {

    ArrayList<ModelRomantic> romanticData;
    Context context_romantic;

    public AdapterRomantic(ArrayList<ModelRomantic> romanticData, Context context_romantic) {
        this.romanticData = romanticData;
        this.context_romantic = context_romantic;
    }



    @NonNull
    @Override
    public viewHolderRomantic onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_romantic_design, parent, false);
        return new viewHolderRomantic(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderRomantic holder, int position) {

        holder.shayariText.setText(romanticData.get(position).getShayari_romantic());
        holder.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context_romantic.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", romanticData.get(position).getShayari_romantic());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context_romantic, "Copied", Toast.LENGTH_SHORT).show();
            }
        });

        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context_romantic, "Added To Favorite", Toast.LENGTH_SHORT).show();
            }
        });
        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent romanticIntent= new Intent(Intent.ACTION_SEND);
                romanticIntent.setType("text/plain");
                romanticIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                romanticIntent.putExtra(Intent.EXTRA_TEXT, romanticData.get(position).getShayari_romantic());
                context_romantic.startActivity(romanticIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return romanticData.size();
    }

    public class viewHolderRomantic extends RecyclerView.ViewHolder {
        TextView shayariText;
        Button shareBtn, copyBtn, favBtn;
        public viewHolderRomantic(@NonNull View itemView) {
            super(itemView);
            shayariText= itemView.findViewById(R.id.shayari_romantic);
            shareBtn =itemView.findViewById(R.id.shareBtn_romantic);
            copyBtn= itemView.findViewById(R.id.copyBtn_romantic);
            favBtn= itemView.findViewById(R.id.favBtn_romantic);
        }
    }
}
