package com.example.mew.New1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mew.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    Context context;
    ArrayList<String> fullNameList;
    ArrayList<String> userNameList;
    ArrayList<String> profilePicList;

    class SearchViewHolder extends RecyclerView.ViewHolder{

        ImageView profileImage;
        TextView full_name, user_name;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = (ImageView) itemView.findViewById(R.id.placethumbnail);
            full_name = (TextView) itemView.findViewById(R.id.txttitle);
            user_name = (TextView) itemView.findViewById(R.id.txtdesc);

        }
    }

    public SearchAdapter(Context context, ArrayList<String> fullNameList, ArrayList<String> userNameList, ArrayList<String> profilePicList) {
        this.context = context;
        this.fullNameList = fullNameList;
        this.userNameList = userNameList;
        this.profilePicList = profilePicList;
    }

    @NonNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_place2, parent, false);
        return new SearchAdapter.SearchViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.full_name.setText(fullNameList.get(position));
        holder.user_name.setText(userNameList.get(position));

        Glide.with(context).asBitmap().load(profilePicList.get(position)).placeholder(R.drawable.mimi1).into(holder.profileImage);
    }



    @Override
    public int getItemCount() {
        return fullNameList.size();
    }
}
