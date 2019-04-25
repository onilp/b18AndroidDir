package com.example.recyclerviewproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Movies> moviesList;

    public MyAdapter(List<Movies> moviesList) {
        this.moviesList = moviesList;
    }

    //create this for different card styles
    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
                break;

            case 1:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout_2, viewGroup, false);
                break;
        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        final Movies movie = moviesList.get(position);
        myViewHolder.titleTextView.setText(movie.getTitle());
        myViewHolder.genreTextView.setText(movie.getGenre());
        myViewHolder.yearTextView.setText(movie.getYear());

        // card click listener
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), movie.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, genreTextView, yearTextView;
        DataCommunicationInterface dataCommunicationInterface;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.title);
            genreTextView = itemView.findViewById(R.id.genre);
            yearTextView = itemView.findViewById(R.id.year);

            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String movieName = titleTextView.getText().toString();
                    String genre = genreTextView.getText().toString();
                    String year = yearTextView.getText().toString();


                    DisplayFragment displayFragment = new DisplayFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("movieName", movieName);
                    bundle.putString("genre", genre);
                    bundle.putString("year", year);
                    displayFragment.setArguments(bundle);

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, displayFragment).addToBackStack(null).commit();
                }
            });
        }
    }
}
