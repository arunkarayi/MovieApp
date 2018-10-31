package com.example.root.movieapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Movie implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("poster_path")
    private String image;

    @SerializedName("vote_average")
    private double rating;

    @SerializedName("title")
    private String title;

    @SerializedName("original_language")
    private String original_language;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("overview")
    private String overview;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String formatDate(){
        String releaseDate = "";
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(release_date);
            String day = new SimpleDateFormat("d",Locale.ENGLISH).format(date);
            switch (Integer.parseInt(day)){
                case 1:
                    day += "st ";
                    break;
                case 2:
                    day += "nd ";
                    break;
                case 3:
                    day += "rd ";
                    break;
                default:
                    day += "th ";
                    break;
            }
            releaseDate += day;
            String month = new SimpleDateFormat("MMMM yyyy",Locale.ENGLISH).format(date);
            releaseDate += month;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return releaseDate;
    }
}
