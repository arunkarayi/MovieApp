package com.example.root.movieapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.root.movieapp.Interfaces.MainInterface;
import com.example.root.movieapp.Model.Movie;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainInterface.setMainView {

    MainInterface.MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this,new GetMovieListImpl());
        presenter.MovieListNetworkCall();

    }


    @Override
    public Void showProgress() {
        return null;
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setRecyclerView(List<Movie> movieList) {
        Toast.makeText(getApplicationContext(),""+movieList.size(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure() {

    }
}
