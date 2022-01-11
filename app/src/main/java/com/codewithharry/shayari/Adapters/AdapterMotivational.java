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

import com.codewithharry.shayari.MotivationalActivity;
import com.codewithharry.shayari.R;
import com.codewithharry.shayari.models.ModelMotivational;

import java.util.ArrayList;

public class AdapterMotivational extends RecyclerView.Adapter<AdapterMotivational.viewHolderMotivational> {


    ArrayList<ModelMotivational> motivaionalData;
    Context context_motivational;


    public AdapterMotivational(ArrayList<ModelMotivational> motivaionalData, Context context_motivational) {
        this.motivaionalData = motivaionalData;
        this.context_motivational= context_motivational;
    }

    @NonNull
    @Override
    public viewHolderMotivational onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_motivational_design, parent, false);
        return new viewHolderMotivational(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderMotivational holder, int position) {

        holder.shayariText.setText(motivaionalData.get(position).getShayari());

        holder.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) context_motivational.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", motivaionalData.get(position).getShayari());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context_motivational, "Copied", Toast.LENGTH_SHORT).show();
            }
        });

        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context_motivational, "Added To Favorite", Toast.LENGTH_SHORT).show();
            }
        });

        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent motivationalIntent= new Intent(Intent.ACTION_SEND);
                motivationalIntent.setType("text/plain");
                motivationalIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                motivationalIntent.putExtra(Intent.EXTRA_TEXT, motivaionalData.get(position).getShayari());
                context_motivational.startActivity(motivationalIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return motivaionalData.size();
    }

    public class viewHolderMotivational extends RecyclerView.ViewHolder {

        TextView shayariText;
        Button copyBtn, shareBtn, favBtn;
        public viewHolderMotivational(@NonNull View itemView) {
            super(itemView);
            shayariText= itemView.findViewById(R.id.shayari);
            copyBtn= itemView.findViewById(R.id.copyBtn);
            shareBtn= itemView.findViewById(R.id.shareBtn);
            favBtn= itemView.findViewById(R.id.fav_Btn);
        }
    }
}
