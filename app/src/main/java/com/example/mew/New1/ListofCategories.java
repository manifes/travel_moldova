package com.example.mew.New1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.mew.R;
import com.example.mew.UserActivity;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListofCategories extends AppCompatActivity {
    private static final String TAG = "ListOfPlaces";
    List<ListPlace> listPlace1;
//    List<ListPlace> listPlace1 = new ArrayList<>();
    List<String> categoryList = new ArrayList<>();
    JSONArray context_arr;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String categoryDoc;
    String searchText;
    SearchView mysearchView;
//    RecycleViewAdapter myAdapter = new RecycleViewAdapter(this, listPlace1);


//    private void makeRequest(final String url) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                OkHttpClient client = new OkHttpClient();
//                Request request = new Request.Builder().url(url).build();
//                try {
//                    Response response = client.newCall(request).execute();
//                    JSONObject json_resp = new JSONObject(response.body().string());
//                    context_arr = json_resp.getJSONArray("context");
//                    System.out.println("RESPONSE!!");
////                    Gson gson = new Gson();
////                    AkulovResponse akulovResponse = gson.fromJson(response.body().string(), AkulovResponse.class);
//                    printResult(context_arr);
//                } catch (IOException | JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//    private void printResult(JSONArray response) throws UnsupportedEncodingException {
//        try {
//            for (int i = 0; i < response.length(); ++i) {
//                JSONObject rec = response.getJSONObject(i);
//                int id = rec.getInt("pk");
//                JSONObject rec_fields = rec.getJSONObject("fields");
//                String name = rec_fields.getString("name");
//                double rating = rec_fields.getDouble("rating");
//                String description = rec_fields.getString("description");
//                listPlace1.add(0, new ListPlace(name, "Categorie Place", description, R.drawable.asconi));
//                System.out.println("PLACE ID -> " + id);
//                System.out.println("PLACE NAME -> " + name);
//                System.out.println("PLACE RATING -> " + rating);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getPlaces(List<String> categoryList, String searchText, RecycleViewAdapter myAdapter, Context context) {
        System.out.println("GETTING PLACES FROM FIREBASE!");
        CollectionReference placesRef = db.collection("places");
        Query query = placesRef.orderBy("rating", Query.Direction.ASCENDING);
        if (searchText != null && !searchText.isEmpty()) {
            query = placesRef.orderBy("name", Query.Direction.DESCENDING).orderBy("rating", Query.Direction.ASCENDING);
            query = query.whereGreaterThanOrEqualTo("name", searchText).whereLessThanOrEqualTo("name", searchText + "\uf8ff");
        }
        if (!categoryList.isEmpty()) {
            List<DocumentReference> categoryRefList = new ArrayList<>();
            categoryList.forEach((docPath) -> categoryRefList.add(db.collection("category").document(docPath)));
//            DocumentReference reference = db.collection("category").document(categoryDoc);
            query = query.whereArrayContainsAny("category", categoryRefList);
        }
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    listPlace1.clear();
                    myAdapter.notifyDataSetChanged();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = (String) document.getData().get("name");
                        String description = (String) document.getData().get("description");
                        String rating = (String) document.getData().get("rating");
                        String image = (String) document.getData().get("image");
                        System.out.println("RESULT -> " + document.getData().get("category"));
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        int id = context.getResources().getIdentifier(image, "drawable", context.getPackageName());
                        listPlace1.add(0, new ListPlace(name, "Categorie Place", description, rating, id));
                        myAdapter.notifyItemInserted(0);
                    }
                } else {
                    Log.w(TAG, "Error getting documents.", task.getException());
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_categories);
        categoryDoc = getIntent().getStringExtra("CATEGORY_DOC");
        searchText = getIntent().getStringExtra("SEARCH_TEXT");

        //SearchView
        mysearchView = (SearchView) findViewById(R.id.searchView);

        listPlace1 = new ArrayList<>();

//        listPlace1.add(new ListPlace("The MIMI", "Categorie Place", "Description Place", R.drawable.mimi1));
//        listPlace1.add(new ListPlace("The Purcari", "Categorie Place", "Description Place", R.drawable.purcari));
//        listPlace1.add(new ListPlace("The  Cricova", "Categorie Place", "Description Place", R.drawable.cricova));
//        listPlace1.add(new ListPlace("The Asconi", "Categorie Place", "Description Place", R.drawable.asconi));
//        listPlace1.add(new ListPlace("The MIMI", "Categorie Place", "Description Place", R.drawable.mimi1));
//        listPlace1.add(new ListPlace("The Purcari", "Categorie Place", "Description Place", R.drawable.purcari));
//        listPlace1.add(new ListPlace("The  Cricova", "Categorie Place", "Description Place", R.drawable.cricova));
//        listPlace1.add(new ListPlace("The Asconi", "Categorie Place", "Description Place", R.drawable.asconi));
//        listPlace1.add(new ListPlace("The MIMI", "Categorie Place", "Description Place", R.drawable.mimi1));
//        listPlace1.add(new ListPlace("The Purcari", "Categorie Place", "Description Place", R.drawable.purcari));
//        listPlace1.add(new ListPlace("The  Cricova", "Categorie Place", "Description Place", R.drawable.cricova));
//        listPlace1.add(new ListPlace("The Asconi", "Categorie Place", "Description Place", R.drawable.asconi));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.list_item_id);
        RecycleViewAdapter myAdapter = new RecycleViewAdapter(this, listPlace1);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);

        mysearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.println("TEXT SUBMITTED! -> " + query);
                getPlaces(categoryList, query, myAdapter, context);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                System.out.println("TEXT CHANGED!");
                return false;
            }
        });

        if (categoryDoc != null && !categoryDoc.isEmpty()) {
            categoryList.add(categoryDoc);
//            get text from search field - fix
            getPlaces(categoryList, searchText, myAdapter, context);
        }

        if (searchText != null && !searchText.isEmpty()) {
            mysearchView.setQuery(searchText, true);
        }


    }

}

//        makeRequest("http://10.0.2.2:8000/places/");

//        try {
//            for (int i = 0; i < context_arr.length(); ++i) {
//                JSONObject rec = context_arr.getJSONObject(i);
//                int id = rec.getInt("pk");
//                JSONObject rec_fields = rec.getJSONObject("fields");
//                String name = rec_fields.getString("name");
//                double rating = rec_fields.getDouble("rating");
//                String description = rec_fields.getString("description");
//                listPlace1.add(2, new ListPlace(name, "Categorie Place", description, R.drawable.asconi));
//                myAdapter.notifyItemInserted(2);
//                System.out.println("PLACE ID -> " + id);
//                System.out.println("PLACE NAME -> " + name);
//                System.out.println("PLACE RATING -> " + rating);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

