package com.example.mew.New1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mew.R;

import java.util.Random;

public class PlaceActivity2 extends AppCompatActivity {

    private TextView tvtitle, tvdescription, tvcategory, ratingDes, location;
    private ImageView img;
    private AppCompatRatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place2);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        ratingDes = (TextView) findViewById(R.id.txtdesc);
        rating = (AppCompatRatingBar) findViewById(R.id.review_stars);
        tvdescription = (TextView) findViewById(R.id.text_card);
        tvcategory = (TextView) findViewById(R.id.txtCat);
        location = (TextView) findViewById(R.id.location);
        img = (ImageView) findViewById(R.id.placethumbnail);

        //Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        String Rating = intent.getExtras().getString("Rating");
        int image = intent.getExtras().getInt("Thumbnail");
        String Distance = new Random().nextInt(3) + "." + new Random().nextInt(10) + " km away";

        //Setting values
        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);
        location.setText(Distance);
        if (Rating != null) {
            rating.setRating(Float.parseFloat(Rating));
            ratingDes.setText(Rating);
        }
        else {
            rating.setRating(5);
            ratingDes.setText("New");
        }


    }
}