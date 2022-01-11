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
import com.codewithharry.shayari.models.ModelFriendship;

import java.util.ArrayList;

public class AdapterFriendship extends RecyclerView.Adapter<AdapterFriendship.viewHolderFriendship> {

    ArrayList<ModelFriendship> friendshipData;
    Context context_friendship;

    public AdapterFriendship(ArrayList<ModelFriendship> friendshipData, Context context_friendship) {
        this.friendshipData = friendshipData;
        this.context_friendship = context_friendship;
    }

    @NonNull
    @Override
    public viewHolderFriendship onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friendship_design, parent, false);
        return new viewHolderFriendship(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderFriendship holder, int position) {
        holder.shayariText.setText(friendshipData.get(position).getShayari_friendship());

        holder.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) context_friendship.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", friendshipData.get(position).getShayari_friendship());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(context_friendship, "Copied", Toast.LENGTH_SHORT).show();
            }
        });
        
        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context_friendship, "Added To Favorite....", Toast.LENGTH_SHORT).show();
            }
        });
        

        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent friendIntent= new Intent(Intent.ACTION_SEND);
                friendIntent.setType("text/plain");
                friendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                friendIntent.putExtra(Intent.EXTRA_TEXT, friendshipData.get(position).getShayari_friendship());
                context_friendship.startActivity(friendIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return friendshipData.size();
    }

    public class viewHolderFriendship extends RecyclerView.ViewHolder {
        TextView shayariText;
        Button shareBtn, copyBtn, favBtn;
        public viewHolderFriendship(@NonNull View itemView) {
            super(itemView);
            shayariText= itemView.findViewById(R.id.shayari_friendship);
            shareBtn= itemView.findViewById(R.id.shareBtn_friendship);
            copyBtn= itemView.findViewById(R.id.copyBtn_friendship);
            favBtn = itemView.findViewById(R.id.favBtn_friendship);
        }
    }
}
