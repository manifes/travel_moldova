package com.example.mew.New1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mew.R;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter <RecycleViewAdapter.MyViewHolder>{


    private Context mContext;
    private List<ListPlace> mData;

    public RecycleViewAdapter(Context mContext, List<ListPlace> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_place_title.setText(mData.get(position).getTitle());
        holder.img_place_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlaceActivity2.class);

                //passing data to the place activity
                intent.putExtra("Title", mData.get(position).getTitle());
                intent.putExtra("Description", mData.get(position).getDescription());
                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());
                intent.putExtra("Rating", mData.get(position).getRating());
                // start the activity
                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_place_title;
        ImageView img_place_thumbnail;
        CardView cardView;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_place_title = (TextView)itemView.findViewById(R.id.mimi_text);
            img_place_thumbnail = (ImageView) itemView.findViewById(R.id.mimi_image);
            cardView = (CardView) itemView.findViewById(R.id.card_view_item_id);
        }
    }
}
