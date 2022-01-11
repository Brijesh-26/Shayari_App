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
import com.codewithharry.shayari.models.ModelBreakup;

import java.util.ArrayList;

public class AdapterBreakup extends RecyclerView.Adapter<AdapterBreakup.viewHolderBreakup> {

    ArrayList<ModelBreakup> breakupData;
    Context context_breakup;

    public AdapterBreakup(ArrayList<ModelBreakup> breakupData, Context context_breakup) {
        this.breakupData = breakupData;
        this.context_breakup = context_breakup;
    }

    @NonNull
    @Override
    public viewHolderBreakup onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_breakup_design, parent, false);
        return new viewHolderBreakup(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderBreakup holder, int position) {

        holder.shayariText.setText(breakupData.get(position).getShayari_breakup());
        holder.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context_breakup.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", breakupData.get(position).getShayari_breakup());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context_breakup, "Copied", Toast.LENGTH_SHORT).show();
            }
        });

        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent breakupIntent= new Intent(Intent.ACTION_SEND);
                breakupIntent.setType("text/plain");
                breakupIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                breakupIntent.putExtra(Intent.EXTRA_TEXT, breakupData.get(position).getShayari_breakup());
                context_breakup.startActivity(breakupIntent);
            }
        });
        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context_breakup, "Added To Favorite", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return breakupData.size();
    }

    public class viewHolderBreakup extends RecyclerView.ViewHolder {
        TextView shayariText;
        Button copyBtn, shareBtn, favBtn;
        public viewHolderBreakup(@NonNull View itemView) {
            super(itemView);
            shayariText= itemView.findViewById(R.id.shayari_breakup);
            copyBtn= itemView.findViewById(R.id.copyBtn_breakup);
            shareBtn= itemView.findViewById(R.id.shareBtn_breakup);
            favBtn= itemView.findViewById(R.id.fav_Btn_breakup);
        }
    }
}
