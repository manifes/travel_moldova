package com.example.mew.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mew.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder> {
    ArrayList<CategoriesHelperClass> categoriesLocations;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categoriesLocations) {
        this.categoriesLocations = categoriesLocations;
    }

    @NonNull
    @Override
    public CategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        CategoriesHolder categoriesHolder = new CategoriesHolder(view);
        return categoriesHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesHolder holder, int position) {
        CategoriesHelperClass categoriesHelperClass = categoriesLocations.get(position);
        holder.image.setImageResource(categoriesHelperClass.getImage());
        holder.background.setBackgroundResource(categoriesHelperClass.getBackground());
        holder.title.setText(categoriesHelperClass.getTitle());
    }

    @Override
    public int getItemCount() {
        return categoriesLocations.size();

    }

    public static class CategoriesHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        RelativeLayout background;

        public CategoriesHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.category_image);
            background = itemView.findViewById(R.id.category_back);
            title = itemView.findViewById(R.id.category_title);
        }
    }

}
