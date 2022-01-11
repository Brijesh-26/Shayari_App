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
import com.codewithharry.shayari.models.ModelBirthday;
import com.codewithharry.shayari.models.ModelLife;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterBirthday extends RecyclerView.Adapter<AdapterBirthday.viewHolderBirthday> {

    ArrayList<ModelBirthday> birthdayData;
    Context context_birthday;

    public AdapterBirthday(ArrayList<ModelBirthday> birthdayData, Context context_birthday) {
        this.birthdayData = birthdayData;
        this.context_birthday = context_birthday;
    }

    @NonNull
    @Override
    public viewHolderBirthday onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_birthday_design, parent, false);
        return new viewHolderBirthday(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderBirthday holder, int position) {

        holder.shayariText.setText(birthdayData.get(position).getShayari_birthday());

        holder.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context_birthday.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", birthdayData.get(position).getShayari_birthday());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context_birthday, "Copied", Toast.LENGTH_SHORT).show();
            }
        });

        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent birthdayIntent= new Intent(Intent.ACTION_SEND);
                birthdayIntent.setType("text/plain");
                birthdayIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                birthdayIntent.putExtra(Intent.EXTRA_TEXT, birthdayData.get(position).getShayari_birthday());
                context_birthday.startActivity(birthdayIntent);
            }
        });

        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context_birthday, "Added To Favorite", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return birthdayData.size();
    }

    public class viewHolderBirthday extends RecyclerView.ViewHolder {
        TextView shayariText;
        Button copyBtn, shareBtn, favBtn;
        public viewHolderBirthday(@NonNull View itemView) {
            super(itemView);
            shayariText= itemView.findViewById(R.id.shayari_birthday);
            copyBtn= itemView.findViewById(R.id.copyBtn_birthday);
            shareBtn= itemView.findViewById(R.id.shareBtn_birthday);
            favBtn= itemView.findViewById(R.id.fav_Btn_birthday);
        }
    }
}
