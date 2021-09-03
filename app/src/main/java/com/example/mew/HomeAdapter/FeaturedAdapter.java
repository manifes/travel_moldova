package com.example.mew.HomeAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mew.New1.PlaceActivity2;
import com.example.mew.New1.RecycleViewAdapter;
import com.example.mew.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter <FeaturedAdapter.FeaturedViewHolder>{
    private Context mContext;
    ArrayList<FeaturedHelperClass> featuredLocations;


    public FeaturedAdapter(Context mContext, ArrayList<FeaturedHelperClass> featuredLocations) {
        this.mContext = mContext;
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.featured_card_design,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);
        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());
        holder.cardViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlaceActivity2.class);

                //passing data to the place activity
                intent.putExtra("Title", featuredLocations.get(position).getTitle());
                intent.putExtra("Description", featuredLocations.get(position).getDescription());
                intent.putExtra("Thumbnail", featuredLocations.get(position).getImage());
                intent.putExtra("Rating", featuredLocations.get(position).getRating());
                // start the activity
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();

    }

//    public static class FeaturedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {
//        private final Context context;
        ImageView image;
        TextView title, desc;
        CardView cardViewItem;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            image  = itemView.findViewById(R.id.featured_image);
            title  = itemView.findViewById(R.id.featured_title);
            desc  = itemView.findViewById(R.id.featured_desc);
            cardViewItem  = itemView.findViewById(R.id.mew);
//            context = itemView.getContext();
        }


//        @Override
//        public void onClick(View v) {
//
//            final Intent intent;
////            switch (getAdapterPostion()){
////                case 0:
////                    intent =  new Intent(context, FirstActivity.class);
////                    break;
////                case 1:
////                    intent =  new Intent(context, SecondActivity.class);
////                    break;
////                default:
////                    intent =  new Intent(context, DefaultActivity.class);
////                    break;
////            }
//            intent =  new Intent(context, DescriptionPlace.class);
//            context.startActivity(intent);
//        }
    }


}
