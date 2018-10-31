package com.example.root.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.root.movieapp.Interfaces.DetailsInterface;
import com.example.root.movieapp.Model.DetailsResponse;
import com.example.root.movieapp.Model.Movie;

public class DetailsActivity extends AppCompatActivity implements DetailsInterface.setDetailsView{

    private DetailsInterface.DetailsPresenter presenter;
    private Movie movie;

    private Toolbar toolbar;
    private ImageView cover_image;
    private TextView runtime;
    private TextView overview;
    private TextView rating;
    private TextView language,genres;
    private TextView dateofrelease,budget,revenue;
    private ProgressBar pb;

    private String imageUrl = "https://image.tmdb.org/t/p/w500/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        movie = (Movie) getIntent().getSerializableExtra("movie");

        cover_image = findViewById(R.id.cover_image);
        runtime = findViewById(R.id.runtime);
        overview = findViewById(R.id.overview);
        rating = findViewById(R.id.rating);
        language = findViewById(R.id.language);
        genres = findViewById(R.id.genres);
        dateofrelease = findViewById(R.id.dateofrelease);
        budget = findViewById(R.id.budget);
        revenue = findViewById(R.id.revenue);
        pb = findViewById(R.id.pb);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(movie.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        presenter = new DetailsPresenter(this, new GetMovDetailsImpl(movie.getId()));
        presenter.MovieDetailsNetworkCall();

        Glide.with(this).load(imageUrl+movie.getBackdrop_path()).into(cover_image);
        overview.setText(movie.getOverview());
        language.setText(movie.getOriginal_language());
        rating.setText(movie.getRating()+"");
        dateofrelease.setText(movie.formatDate());
    }

    @Override
    public void showProgress() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void setViews(DetailsResponse detailsResponse) {
        runtime.setText(detailsResponse.getRuntime()+" minutes");
        genres.setText(detailsResponse.getGenreString());
        revenue.setText(detailsResponse.getMoneyFormat(detailsResponse.getRevenue()));
        budget.setText(detailsResponse.getMoneyFormat(detailsResponse.getBudget()));
    }

    @Override
    public void onFailure(Throwable throwable) {
        pb.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
    }
}
