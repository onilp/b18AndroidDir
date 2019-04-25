package com.example.b18fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentOne extends Fragment {

    EditText usernameEditText, passwordEditText;
    Button loginButton;
    LoginDataInterface loginDataInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

//        button = view.findViewById(R.id.button);

//        FragmentTwo fragmentTwo = new FragmentTwo();
//        Bundle bundle = new Bundle();
//        bundle.putString("key", "Cal");
//        fragmentTwo.setArguments(bundle);

        usernameEditText = view.findViewById(R.id.usernameEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDataInterface.loginData(usernameEditText.getText().toString(), passwordEditText.getText().toString());
//                Toast.makeText(getContext(), getContext().toString(), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        loginDataInterface = (LoginDataInterface) getActivity();
//    }
}
