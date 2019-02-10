package com.example.hollyquran.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hollyquran.Model.Quran_Model;
import com.example.hollyquran.Model.Read_model;
import com.example.hollyquran.R;

import java.util.List;

public class Quran_Adapter extends RecyclerView.Adapter<Quran_Adapter.viewHolder> {

    List<Quran_Model> items;
    OnItemClickListener imageOnItemClick;
    OnItemClickListener nameOnItemClick;
    OnItemClickListener itemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setImageOnItemClick(OnItemClickListener imageOnItemClick) {
        this.imageOnItemClick = imageOnItemClick;
    }

    public void setNameOnItemClick(OnItemClickListener nameOnItemClick) {
        this.nameOnItemClick = nameOnItemClick;
    }

    public Quran_Adapter(List<Quran_Model> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.quran_item,viewGroup,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, final int pos) {
          final Quran_Model  quran_model=items.get(pos);
        viewHolder.image.setImageResource(quran_model.getImage());
        viewHolder.name.setText(quran_model.getName());
        if(imageOnItemClick!=null) {
            viewHolder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    imageOnItemClick.onItemClick(pos, quran_model);

                }

            });
        }
        if(nameOnItemClick!=null) {
            viewHolder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    nameOnItemClick.onItemClick(pos, quran_model);

                }

            });
        }



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        ImageView image;
        View parent;
        public viewHolder(@NonNull View view) {
            super(view);
            name=view.findViewById(R.id.textView);
            image=view.findViewById(R.id.imageView);
            parent = view ;
        }
    }
    public interface OnItemClickListener
    {
        void onItemClick(int pos, Quran_Model Read);
    }


}
