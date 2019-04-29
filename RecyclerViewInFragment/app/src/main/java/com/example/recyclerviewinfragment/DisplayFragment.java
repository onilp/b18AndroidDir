package com.example.recyclerviewinfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayFragment extends Fragment {
    TextView displayNameTextView, displayAgeTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        displayNameTextView = view.findViewById(R.id.display_name_textview);
        displayAgeTextView = view.findViewById(R.id.display_age_textview);

        Bundle bundle = getArguments();
        displayNameTextView.setText(bundle.getString("name"));
        displayAgeTextView.setText(bundle.getString("age"));
        return view;
    }
}
