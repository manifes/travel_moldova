package com.example.mew.New1;

public class ListPlace {
    private String Title;
    private String Category;
    private String Description;
    private int Thumbnail;
    private String Rating;

    public ListPlace() {
    }

    public ListPlace(String title, String category, String description, String rating, int thumbnail) {
        Title = title;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
        Rating = rating;
    }

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public String getRating() {
        return Rating;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
