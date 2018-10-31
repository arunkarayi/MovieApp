package com.example.root.movieapp.Model;

import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by arun on 10/31/18.
 * Purpose -
 */

public class DetailsResponse {

    @SerializedName("genres")
    private List<Genre> genreList;

    @SerializedName("budget")
    private float budget;

    @SerializedName("revenue")
    private float revenue;

    @SerializedName("runtime")
    private int runtime;

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getGenreString(){
        String genres = "";
        for (Genre genre : genreList) {
            genres += genre.getName() + ",";
        }
        return genres.substring(0,genres.length()-1);
    }

    public String getMoneyFormat(float amount){
        String val = "$";
        float thsnd = 1000;
        float million = 1000000;
        float billion = 1000000000;
        float trillion = 1000000000000L;

        if (amount < million){
            amount = amount/thsnd;
            val += amount + " Thousand";
        }else if (amount < billion){
            amount = amount/million;
            val += amount + " Million";
        }else if (amount < trillion){
            amount = amount/billion;
            val += amount + " Billion";
        }else {
            amount = amount/trillion;
            val += amount + " Trillion";
        }
        return val;
    }
}
