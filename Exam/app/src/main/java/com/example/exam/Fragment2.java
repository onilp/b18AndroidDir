package com.example.exam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    TextView usernameTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        usernameTextView = view.findViewById(R.id.usernameTextView);

        Bundle bundle = getArguments();

        Log.i("frag 2 username", bundle.getString("username"));
//        usernameTextView.setText(bundle.getString("username"));

        return view;
    }
}
