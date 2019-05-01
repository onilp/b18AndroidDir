package com.example.recyclerviewmvp;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;

    public MainPresenter(MainActivity mainActivity) {
        view = mainActivity;
    }


    @Override
    public void listItemClicked(String name) {
        view.showToast(name);
    }
}
