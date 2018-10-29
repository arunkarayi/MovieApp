package com.example.root.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.root.movieapp.Adapters.MovieListAdapter;
import com.example.root.movieapp.Interfaces.MainInterface;
import com.example.root.movieapp.Interfaces.MovieListItemClickListener;
import com.example.root.movieapp.Model.Movie;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainInterface.setMainView {

    private MainInterface.MainPresenter presenter;

    private RecyclerView movie_reclrvw;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movie_reclrvw = findViewById(R.id.movie_reclrvw);
        pb = findViewById(R.id.pb);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        movie_reclrvw.setLayoutManager(layoutManager);

        presenter = new MainPresenter(this,new GetMovieListImpl());
        presenter.MovieListNetworkCall();

    }

    private MovieListItemClickListener movieListItemClickListener = new MovieListItemClickListener() {
        @Override
        public void onItemClick(Movie movie) {
            Toast.makeText(getApplicationContext(),movie.getTitle(),Toast.LENGTH_SHORT).show();
            Intent intent;
        }
    };


    @Override
    public void showProgress() {
        movie_reclrvw.setVisibility(View.GONE);
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void setRecyclerView(List<Movie> movieList) {
        pb.setVisibility(View.GONE);
        MovieListAdapter movieListAdapter = new MovieListAdapter(movieList, movieListItemClickListener);
        movie_reclrvw.setAdapter(movieListAdapter);
    }

    @Override
    public void onFailure() {
// TODO: 30/10/18 error layout
    }
}
