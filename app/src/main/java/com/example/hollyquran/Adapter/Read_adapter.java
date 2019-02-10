package com.example.hollyquran.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hollyquran.Model.Quran_Model;
import com.example.hollyquran.Model.Read_model;
import com.example.hollyquran.R;

import java.util.ArrayList;
import java.util.List;

public class Read_adapter extends RecyclerView.Adapter<Read_adapter.viewHolder> {
    ArrayList<String> items;


    public Read_adapter(ArrayList<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.read_item,viewGroup,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        String read_model=items.get(i);
        viewHolder.name.setText(read_model);



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        ImageView image;
        public viewHolder(@NonNull View view) {
            super(view);
            name=view.findViewById(R.id.textView2);
            image=view.findViewById(R.id.image2);
        }
    }

}
