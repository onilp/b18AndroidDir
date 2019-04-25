package com.example.recyclerviewproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayFragment extends Fragment {
    TextView movieNameTextView, genreTextView, yearTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.display_fragment, container, false);

        movieNameTextView = view.findViewById(R.id.movieTextView);
        genreTextView = view.findViewById(R.id.genreTextView);
        yearTextView = view.findViewById(R.id.yearTextView);

        movieNameTextView.setText(getArguments().getString("movieName"));
        genreTextView.setText(getArguments().getString("genre"));
        yearTextView.setText(getArguments().getString("year"));

        return view;
    }

}
