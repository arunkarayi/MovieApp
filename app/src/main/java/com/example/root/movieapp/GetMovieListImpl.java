package com.example.root.movieapp;

import com.example.root.movieapp.Interfaces.MainInterface;
import com.example.root.movieapp.Model.MovieListResponse;
import com.example.root.movieapp.Network.RetrofitInstance;
import com.example.root.movieapp.Network.RetrofitService;

import retrofit2.Callback;
import retrofit2.Response;

public class GetMovieListImpl implements MainInterface.getMovieListInteractor {

    @Override
    public void getMovieList(final onFinishedListener onFinishedListener) {
        RetrofitService service = RetrofitInstance.getRetrofitInstance().create(RetrofitService.class);
        retrofit2.Call<MovieListResponse> call = service.getMovieList("popularity.desc","55d16a54bc286bc2cb64b8fef4f1a2b1");
        call.enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(retrofit2.Call<MovieListResponse> call, Response<MovieListResponse> response) {
                onFinishedListener.onFinished(response.body().getMovieList());
            }

            @Override
            public void onFailure(retrofit2.Call<MovieListResponse> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
