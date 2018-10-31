package com.example.root.movieapp;

import com.example.root.movieapp.Interfaces.DetailsInterface;
import com.example.root.movieapp.Model.DetailsResponse;

/**
 * Created by arun on 10/31/18.
 * Purpose -
 */

public class DetailsPresenter implements DetailsInterface.DetailsPresenter, DetailsInterface.getMovieDetailsInteractor.onFinishedListener{

    private DetailsInterface.setDetailsView detailsView;
    private DetailsInterface.getMovieDetailsInteractor getMovieDetailsInteractor;

    public DetailsPresenter(DetailsInterface.setDetailsView detailsView, DetailsInterface.getMovieDetailsInteractor getMovieDetailsInteractor) {
        this.detailsView = detailsView;
        this.getMovieDetailsInteractor = getMovieDetailsInteractor;
    }

    @Override
    public void onDestroy() {
        detailsView = null;
    }

    @Override
    public void MovieDetailsNetworkCall() {
        getMovieDetailsInteractor.getMovieDetails(this);
        detailsView.showProgress();
    }

    @Override
    public void onFinished(DetailsResponse detailsResponse) {
        detailsView.setViews(detailsResponse);
        detailsView.hideProgress();
    }

    @Override
    public void inFailure(Throwable throwable) {
        detailsView.onFailure(throwable);
    }
}
