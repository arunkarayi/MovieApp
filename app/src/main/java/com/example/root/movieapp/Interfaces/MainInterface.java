package com.example.root.movieapp.Interfaces;

import com.example.root.movieapp.Model.Movie;

import java.util.List;

public interface MainInterface {

    interface MainPresenter{

        void OnDestroy();

        void MovieListNetworkCall();
    }


    interface getMovieListInteractor{

        interface onFinishedListener{

            void onFinished(List<Movie> movieList);

            void onFailure(Throwable throwable);
        }

        void getMovieList(onFinishedListener onFinishedListener);
    }


    interface setMainView{

        void showProgress();

        void hideProgress();

        void setRecyclerView(List<Movie> movieList);

        void onFailure();
    }



}
