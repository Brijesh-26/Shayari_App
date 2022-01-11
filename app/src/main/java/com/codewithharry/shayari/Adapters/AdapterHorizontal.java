package com.codewithharry.shayari.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithharry.shayari.R;
import com.codewithharry.shayari.models.ModelHorizonatal;

import java.util.ArrayList;
import java.util.List;

public class AdapterHorizontal extends RecyclerView.Adapter<AdapterHorizontal.viewHolderHorizontal> {

    private List<ModelHorizonatal> arrayList_horizontal;
    Context context;

    public AdapterHorizontal(ArrayList<ModelHorizonatal> arrayList_horizontal, Context context) {
        this.arrayList_horizontal = arrayList_horizontal;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolderHorizontal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal_design, parent, false);
        return new viewHolderHorizontal(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderHorizontal holder, int position) {

        ModelHorizonatal modelHorizonatal= arrayList_horizontal.get(position);

//       holder.imageView.setImageResource(modelHorizonatal.get(position).getImageView_horizontal());
//
//       holder.name.setText(arrayList_horizontal.get(position).getName_horizontal());

        holder.imageView.setImageResource(modelHorizonatal.getImageView_horizontal());
        holder.name.setText(modelHorizonatal.getName_horizontal());
    }

    @Override
    public int getItemCount() {
        return arrayList_horizontal.size();
    }

    public class viewHolderHorizontal extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        public viewHolderHorizontal(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.imageView_horizontal);
            name= itemView.findViewById(R.id.textView_horizontal);
        }
    }
}
