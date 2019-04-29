package com.example.recyclerviewinfragment;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    UsersModel user;

    MainPresenter(MainContract.View view) {
        this.view = view;
    }

    public void addUsers(List<UsersModel> userList) {
        userList = new ArrayList<>();
        userList.add(new UsersModel("Test", "21"));
        userList.add(new UsersModel("Ben", "19"));
        userList.add(new UsersModel("Jane", "25"));
        view.setDataToAdapter(userList);
    }

    @Override
    public void clickedData(String name, String age) {
        DisplayFragment displayFragment = new DisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("age", age);
        displayFragment.setArguments(bundle);
        view.redirectToDisplayFragment(displayFragment);
    }
}
