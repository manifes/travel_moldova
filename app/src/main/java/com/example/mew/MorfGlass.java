package com.example.mew;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.WindowManager;


import com.cuberto.liquid_swipe.LiquidPager;

public class MorfGlass extends AppCompatActivity {

    private LiquidPager pager;
    ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_morf_glass);

        pager = findViewById(R.id.pager);
        adapter  = new ViewPagerAdapter(getSupportFragmentManager(), 1);
        pager.setAdapter(adapter);


        //blurView = (BlurView)findViewById(R.id.blurLayout);

        //blurBackgraund();

    }


//    private void blurBackgraund() {
//        float radius = 0.50f;
//
//        View decorView = getWindow().getDecorView();
//        //ViewGroup you want to start blur from. Choose root as close to BlurView in hierarchy as possible.
//        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
//        //Set drawable to draw in the beginning of each blurred frame (Optional).
//        //Can be used in case your layout has a lot of transparent space and your content
//        //gets kinda lost after after blur is applied.
//        Drawable windowBackground = decorView.getBackground();
//
//        blurView.setupWith(rootView)
//                .setFrameClearDrawable(windowBackground)
//                .setBlurAlgorithm(new RenderScriptBlur(this))
//                .setBlurRadius(radius)
//                .setBlurAutoUpdate(true)
//                .setHasFixedTransformationMatrix(true); // Or false if it's in a scrolling container or might be animated
//
//    }


}



