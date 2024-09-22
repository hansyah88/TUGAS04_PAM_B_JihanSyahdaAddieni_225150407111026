package com.example.tugas04_pam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Item> itemList;

    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.fvId.setText(item.getId());
        holder.fvName.setText(item.getName());
        holder.imageView.setImageResource(R.drawable.ic_android);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fvId, fvName;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fvId = itemView.findViewById(R.id.fvId);
            fvName = itemView.findViewById(R.id.fvName);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

