package com.example.recyclerviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView movieRecyclerView;
    MyAdapter myAdapter;
    List<Movies> moviesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRecyclerView = findViewById(R.id.movieRecyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        movieRecyclerView.setLayoutManager(layoutManager);
        myAdapter = new MyAdapter(moviesList);
        movieRecyclerView.setAdapter(myAdapter);

        addRecords();
    }

    private void addRecords() {
        Movies m = new Movies("Avenger", "Action", "2019");
        moviesList.add(m);
        Movies m1 = new Movies("Avenger2", "Action", "2020");
        moviesList.add(m1);
        Movies m2 = new Movies("Avenger3", "Action", "2021");
        moviesList.add(m2);
        Movies m3 = new Movies("Avenger4", "Action", "2022");
        moviesList.add(m3);
    }

}
