package com.codewithharry.shayari.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithharry.shayari.BirthdayActivity;
import com.codewithharry.shayari.BreakupActivity;
import com.codewithharry.shayari.FriendshipActivity;
import com.codewithharry.shayari.FunnyActivity;
import com.codewithharry.shayari.LifeActivity;
import com.codewithharry.shayari.MotivationalActivity;
import com.codewithharry.shayari.R;
import com.codewithharry.shayari.RomanticActivity;
import com.codewithharry.shayari.WineActivity;
import com.codewithharry.shayari.models.ModelHome;
import com.codewithharry.shayari.patrioticActivity;

import java.util.ArrayList;

public class AdapterHome extends  RecyclerView.Adapter<AdapterHome.viewHolder>{

    ArrayList<ModelHome> dataholder;
    Context context;
    public AdapterHome(ArrayList<ModelHome> dataholder, Context context) {
        this.dataholder = dataholder;
        this.context= context;

    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_design, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final ModelHome temp= dataholder.get(position);

        holder.imageView.setImageResource(dataholder.get(position).getImageview1());
        holder.textView.setText(dataholder.get(position).getTextview1());

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int x= holder.getAdapterPosition();

                switch (holder.getAdapterPosition()){
                    case 0:
                        Intent intent1= new Intent(context, MotivationalActivity.class);
//                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent1);
                        break;
//
//                    case 1:
//                        Intent intent2= new Intent(context, SadActivity.class);
////                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        context.startActivity(intent2);
//                        break;

                    case 1:
                        Intent intent3= new Intent(context, RomanticActivity.class);
//                        intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent3);
                        break;

                    case 2:
                        Intent intent4= new Intent(context, FriendshipActivity.class);
//                        intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent4);
                        break;

                    case 3:
                        Intent intent5= new Intent(context, LifeActivity.class);
//                        intent5.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent5);
                        break;

//                    case 4:
//                        Intent intent6= new Intent(context, FunnyActivity.class);
////                        intent6.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        context.startActivity(intent6);
//                        break;

                    case 4:
                        Intent intent7= new Intent(context, WineActivity.class);
//                        intent7.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent7);
                        break;

                    case 5:
                        Intent intent8= new Intent(context, BirthdayActivity.class);
//                        intent8.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent8);
                        break;

                    case 6:
                        Intent intent9= new Intent(context, patrioticActivity.class);
//                        intent8.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent9);
                        break;

                    case 7:
                        Intent intent10= new Intent(context, BreakupActivity.class);
                        context.startActivity(intent10);
                        break;

                    case 8:
                        Intent intent11= new Intent(context, FunnyActivity.class);
                        context.startActivity(intent11);
                        break;

                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.image_home);
            textView = itemView.findViewById(R.id.text_home);
        }
    }
}
