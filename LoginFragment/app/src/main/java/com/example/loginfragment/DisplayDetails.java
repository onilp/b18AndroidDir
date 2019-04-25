package com.example.loginfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayDetails extends Fragment {
    TextView usernameTextView, passwordTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.display_details, container, false);

        usernameTextView = view.findViewById(R.id.usernameTextView);
        passwordTextView = view.findViewById(R.id.passwordTextView);

        Bundle bundle = getArguments();

        usernameTextView.setText(bundle.getString("username"));
        passwordTextView.setText(bundle.getString("password"));

        /**
         * This is a longer way
         */
//        String username = bundle.getString("username");
//        String password = bundle.getString("password");
//        usernameTextView.setText(username);
//        passwordTextView.setText(password);

        return view;
    }
}
