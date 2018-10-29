package com.example.root.movieapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.root.movieapp.Interfaces.MovieListItemClickListener;
import com.example.root.movieapp.Model.Movie;
import com.example.root.movieapp.R;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.Holder> {

    private List<Movie> movieList;
    private String url = "https://image.tmdb.org/t/p/w500/";
    private MovieListItemClickListener movieListItemClickListener;

    public MovieListAdapter(List<Movie> movieList, MovieListItemClickListener movieListItemClickListener) {
        this.movieList = movieList;
        this.movieListItemClickListener = movieListItemClickListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item_layout,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        Glide.with(holder.poster).load(url+movieList.get(i).getImage()).into(holder.poster);
        holder.title.setText(movieList.get(i).getTitle());
        holder.overview.setText(movieList.get(i).getOverview());
        holder.rating.setText(""+movieList.get(i).getRating());
        holder.language.setText(movieList.get(i).getOriginal_language());
        // TODO: 30/10/18 date conversion

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieListItemClickListener.onItemClick(movieList.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView poster;
        TextView title, overview, language, rating, date;
        CardView cardView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            overview = itemView.findViewById(R.id.overview);
            language = itemView.findViewById(R.id.language);
            rating = itemView.findViewById(R.id.rating);
            date = itemView.findViewById(R.id.date);
            poster = itemView.findViewById(R.id.poster);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }

}
