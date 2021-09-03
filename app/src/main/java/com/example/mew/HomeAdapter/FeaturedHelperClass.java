package com.example.mew.HomeAdapter;

public class FeaturedHelperClass {
    int image;
    String title, description, rating;

    public FeaturedHelperClass(int image, String title, String description, String rating) {
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

    public String getRating() {
        return rating;
    }
}
