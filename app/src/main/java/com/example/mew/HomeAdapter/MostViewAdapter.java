package com.example.mew.HomeAdapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mew.R;

import java.util.ArrayList;

public class MostViewAdapter extends RecyclerView.Adapter <MostViewAdapter.MostViewHolder> {
    ArrayList<MostViewHelperClass> mostViewLocations;

    public MostViewAdapter(ArrayList<MostViewHelperClass> mostViewLocations) {
        this.mostViewLocations = mostViewLocations;
    }

    @NonNull
    @Override
    public MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
        MostViewHolder mostViewHolder = new MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewHolder holder, int position) {
        MostViewHelperClass mostViewHelperClass = mostViewLocations.get(position);
        holder.image.setImageResource(mostViewHelperClass.getImage());
        holder.title.setText(mostViewHelperClass.getTitle());
        holder.desc.setText(mostViewHelperClass.getDescription());
        holder.rating.setRating(mostViewHelperClass.getRating());
    }

    @Override
    public int getItemCount() {
        return mostViewLocations.size();

    }

    public static class MostViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        RatingBar rating;
        TextView title, desc;

        public MostViewHolder(@NonNull View itemView) {
            super(itemView);
            image  = itemView.findViewById(R.id.mv_image);
            title  = itemView.findViewById(R.id.mv_title);
            desc  = itemView.findViewById(R.id.mv_desc);
            rating = itemView.findViewById(R.id.mv_rating);
        }
    }

}
