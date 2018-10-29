package com.example.root.movieapp.Network;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("discover/movie")
    Call<ResponseBody> getMovieList(@Query("sort_by") String sortBy, @Query("api_key") String api);

}
