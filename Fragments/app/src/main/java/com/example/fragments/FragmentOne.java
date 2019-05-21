package com.example.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class FragmentOne extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Fragment one", Toast.LENGTH_SHORT).show();
                FragmentTwo fragmentTwo = new FragmentTwo();
                Bundle bundle = new Bundle();
                bundle.putString("username", "Calvert");
                fragmentTwo.setArguments(bundle);
                Objects.requireNonNull(getFragmentManager()).beginTransaction().replace(R.id.myLayout, fragmentTwo).addToBackStack(null).commit();
            }
        });
        return view;
    }
}
