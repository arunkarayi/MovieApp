package com.example.root.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Popular Movies");

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
            Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
            intent.putExtra("movie",movie);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

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
        Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
    }
}
