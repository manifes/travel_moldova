package com.example.mew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mew.HomeAdapter.FeaturedAdapter;
import com.example.mew.HomeAdapter.FeaturedHelperClass;
import com.example.mew.HomeAdapter.MostViewAdapter;
import com.example.mew.HomeAdapter.MostViewHelperClass;
import com.example.mew.HomeAdapter.CategoriesAdapter;
import com.example.mew.HomeAdapter.CategoriesHelperClass;
import com.example.mew.New1.ListPlace;
import com.example.mew.New1.ListofCategories;
import com.example.mew.New1.RecycleViewAdapter;
import com.example.mew.PlacesModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    RecyclerView featuredRecycler;
    RecyclerView.Adapter featuredAdapter;
    RecyclerView mostViewRecycler;
    RecyclerView.Adapter mostViewAdapter;
    RecyclerView categoriesRecycler;
    RecyclerView.Adapter categoriesAdapter;
    ImageView menuIcon;
    //Draw menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    RelativeLayout cardView;
    ImageView winery;
    ImageView cafe_btn;
    ImageView shops_btn;
    ImageView village_btn;
    SearchView searchPlace;
    ImageView plus;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
//        mostViewRecycler = findViewById(R.id.most_view_recycler);
//        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        winery = findViewById(R.id.image_b);
        cafe_btn = findViewById(R.id.cafe_button);
        shops_btn = findViewById(R.id.shops_button);
        village_btn = findViewById(R.id.village_button);
        searchPlace = (SearchView) findViewById(R.id.search_edit_text);
        plus= (ImageView)findViewById(R.id.plus);

        //MenuHooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        cardView = findViewById(R.id.card_view);

        navigationDrawer();


//Recycle views  function calls
        featuredRecycler();
//        mostViewRecycler();
//        categoriesRecycler();

        searchPlace.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.println("TEXT SUBMITTED! -> " + query);
                Intent intent = new Intent(UserActivity.this, ListofCategories.class);
                intent.putExtra("SEARCH_TEXT", query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                System.out.println("TEXT CHANGED!");
                return false;
            }
        });


        winery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, ListofCategories.class);
                intent.putExtra("CATEGORY_DOC", "C1d73svRrDOjgxCS2r81");
                startActivity(intent);
            }
        });

       plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, MorfGlass.class);
                startActivity(intent);
            }
        });

        cafe_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, ListofCategories.class);
                intent.putExtra("CATEGORY_DOC", "jFXsUUoDMisUubk9SRS2");
                startActivity(intent);
            }
        });

        shops_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, ListofCategories.class);
                intent.putExtra("CATEGORY_DOC", "6gNn8MajX5WZWADQjs0I");
                startActivity(intent);
            }
        });

        village_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, ListofCategories.class);
                intent.putExtra("CATEGORY_DOC", "EcVUBv7kE65dB6LC3eRN");
                startActivity(intent);
            }
        });



    }

    private void navigationDrawer() {
        //Navigation  Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }

        });


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else super.onBackPressed();
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2, "Cobusca Noua", "Самое популярное лавандовое поле находится в  Cobusca Noua.", "4.5"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.selfie, "Selfie museum", "В Кишиневе впервые открылся музей селфи с 18 вариантами фотоссесий", "4.5"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.mac, "Mcdonald's", "Restaurantele McDonald's oferă produse 100% proaspete, oricând și oriunde.", "4.5"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_1, "No", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "4.5"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2, "Yes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "4.5"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2, "Yes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "4.5"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2, "Yes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "4.5"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2, "Yes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "4.5"));

        featuredAdapter = new FeaturedAdapter(this, featuredLocations);
        featuredRecycler.setAdapter(featuredAdapter);
    }

//    private void mostViewRecycler() {
//        mostViewRecycler.setHasFixedSize(true);
//        mostViewRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//
//        ArrayList<MostViewHelperClass> mostViewLocations = new ArrayList<>();
//
//        mostViewLocations.add(new MostViewHelperClass(R.drawable.mac, "Mcdonald's", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", (float) 4));
//        mostViewLocations.add(new MostViewHelperClass(R.drawable.city_1, "No", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", (float) 3.5));
//        mostViewLocations.add(new MostViewHelperClass(R.drawable.donuts, "Donuts", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", (float) 4.7));
//
//        mostViewAdapter = new MostViewAdapter(mostViewLocations);
//        mostViewRecycler.setAdapter(mostViewAdapter);
//    }
//
//    private void categoriesRecycler() {
//        categoriesRecycler.setHasFixedSize(true);
//        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//
//        ArrayList<CategoriesHelperClass> categoriesLocations = new ArrayList<>();
//
//        categoriesLocations.add(new CategoriesHelperClass(R.drawable.restaurant2, R.drawable.restaurant, "Donuts"));
//        categoriesLocations.add(new CategoriesHelperClass(R.drawable.mac, R.drawable.restaurant, "Mcdonald's"));
//        categoriesLocations.add(new CategoriesHelperClass(R.drawable.city_1, R.drawable.restaurant, "No"));
//
//        categoriesAdapter = new CategoriesAdapter(categoriesLocations);
//        categoriesRecycler.setAdapter(categoriesAdapter);
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
    }

}

