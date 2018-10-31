package com.example.root.movieapp;

import com.example.root.movieapp.Interfaces.DetailsInterface;
import com.example.root.movieapp.Model.DetailsResponse;
import com.example.root.movieapp.Network.RetrofitInstance;
import com.example.root.movieapp.Network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by arun on 10/31/18.
 * Purpose -
 */

public class GetMovDetailsImpl implements DetailsInterface.getMovieDetailsInteractor {

    private int id;

    public GetMovDetailsImpl(int id) {
        this.id = id;
    }

    @Override
    public void getMovieDetails(final onFinishedListener onFinishedListener) {
        RetrofitService service = RetrofitInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<DetailsResponse> detailsResponseCall = service.getMovieDetails(id,"55d16a54bc286bc2cb64b8fef4f1a2b1");
        detailsResponseCall.enqueue(new Callback<DetailsResponse>() {
            @Override
            public void onResponse(Call<DetailsResponse> call, Response<DetailsResponse> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<DetailsResponse> call, Throwable t) {
                onFinishedListener.inFailure(t);
            }
        });
    }
}
