package com.example.mew.HomeAdapter;

public class CategoriesHelperClass {
    int image, background;
    String title;

    public CategoriesHelperClass(int image, int background, String title) {
        this.image = image;
        this.title = title;
        this.background = background;
    }

    public int getImage() {
        return image;
    }

    public int getBackground() {
        return background;
    }

    public String getTitle() {
        return title;
    }
}
