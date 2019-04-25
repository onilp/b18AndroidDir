package com.example.exam2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentInput extends Fragment {

    EditText usernameEditText;
    Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        usernameEditText = view.findViewById(R.id.usernameEditText);
        submitButton = view.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentOutput fragmentOutput = new FragmentOutput();
                Bundle bundle = new Bundle();
                bundle.putString("username", usernameEditText.getText().toString());
                fragmentOutput.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentDefault, fragmentOutput).commit();
            }
        });

        return view;
    }
}
