package com.example.root.movieapp.Interfaces;

import com.example.root.movieapp.Model.DetailsResponse;

/**
 * Created by arun on 10/31/18.
 * Purpose -
 */

public interface DetailsInterface {

    interface DetailsPresenter{

        void onDestroy();

        void MovieDetailsNetworkCall();
    }

    interface getMovieDetailsInteractor{

        interface onFinishedListener{

            void onFinished(DetailsResponse detailsResponse);

            void inFailure(Throwable throwable);
        }

        void getMovieDetails(onFinishedListener onFinishedListener);
    }

    interface setDetailsView{

        void showProgress();

        void hideProgress();

        void setViews(DetailsResponse detailsResponse);

        void onFailure(Throwable throwable);
    }

}
