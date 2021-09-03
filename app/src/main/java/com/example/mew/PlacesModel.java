package com.example.mew;

public class PlacesModel {
    int id;
    String name, location, time_from, time_to, description;
    float rating;

    public PlacesModel(int id, String name, float rating, String time_from, String time_to,  String location, String description) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.time_from = time_from;
        this.time_to = time_to;
        this.location = location;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public String getTimeFrom() {
        return time_from;
    }

    public String getTimeTo() {
        return time_to;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }
}
