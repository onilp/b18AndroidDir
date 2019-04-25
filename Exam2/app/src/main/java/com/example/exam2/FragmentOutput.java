package com.example.exam2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentOutput extends Fragment {
    TextView usernameTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_output, container, false);

        usernameTextView = view.findViewById(R.id.usernameTextView);

        Bundle bundle = getArguments();
        usernameTextView.setText(bundle.getString("username"));

        return view;
    }
}
