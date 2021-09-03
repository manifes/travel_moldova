package com.example.mew.HomeAdapter;


public class MostViewHelperClass {
    int image;
    float rating;
    String title, description;

    public MostViewHelperClass(int image, String title, String description, float rating) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public float getRating() {
        return rating;
    }
}
