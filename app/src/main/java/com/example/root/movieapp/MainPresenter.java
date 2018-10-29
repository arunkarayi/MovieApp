package com.example.root.movieapp;

import com.example.root.movieapp.Interfaces.MainInterface;
import com.example.root.movieapp.Model.Movie;

import java.util.List;

public class MainPresenter implements MainInterface.MainPresenter,MainInterface.getMovieListInteractor.onFinishedListener {

    private MainInterface.setMainView mainView;
    private MainInterface.getMovieListInteractor getMovieListInteractor;

    public MainPresenter(MainInterface.setMainView mainView, MainInterface.getMovieListInteractor getMovieListInteractor) {
        this.mainView = mainView;
        this.getMovieListInteractor = getMovieListInteractor;
    }

    @Override
    public void OnDestroy() {
        mainView = null;
    }

    @Override
    public void MovieListNetworkCall() {
        getMovieListInteractor.getMovieList(this);
    }

    @Override
    public void onFinished(List<Movie> movieList) {
        mainView.setRecyclerView(movieList);
    }

    @Override
    public void onFailure(Throwable throwable) {
        mainView.onFailure();
    }
}
