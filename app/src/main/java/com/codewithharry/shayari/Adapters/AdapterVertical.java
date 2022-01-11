package com.codewithharry.shayari.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithharry.shayari.R;
import com.codewithharry.shayari.models.ModelVertical;

import java.util.List;

public class AdapterVertical extends RecyclerView.Adapter<AdapterVertical.viewHolderVertical> {

    private RecyclerView.RecycledViewPool viewPool= new RecyclerView.RecycledViewPool();

    private List<ModelVertical> itemList;
    Context context;

    public AdapterVertical(List<ModelVertical> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolderVertical onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item, parent, false);
        return new viewHolderVertical(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderVertical holder, int position) {

        ModelVertical modelVertical= itemList.get(position);

        holder.textView_title.setText(modelVertical.getTitle());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolderVertical extends RecyclerView.ViewHolder {

        TextView textView_title;
        public viewHolderVertical(@NonNull View itemView) {
            super(itemView);

            textView_title= itemView.findViewById(R.id.title);
        }
    }
}
