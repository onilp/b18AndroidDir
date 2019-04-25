package com.example.loginfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginForm extends Fragment {
    EditText usernameEditText, passwordEditText;
    Button loginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_form, container, false);

        usernameEditText = view.findViewById(R.id.loginUsernameEditText);
        passwordEditText = view.findViewById(R.id.loginPasswordEditText);
        loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("username", usernameEditText.getText().toString());
                bundle.putString("password", passwordEditText.getText().toString());

                DisplayDetails displayDetails = new DisplayDetails();
                displayDetails.setArguments(bundle);

                getFragmentManager().beginTransaction()
                        .replace(R.id.containerLayout, displayDetails)
                        .addToBackStack(null)
                        .commit();
            }
        });


        return view;
    }
}
