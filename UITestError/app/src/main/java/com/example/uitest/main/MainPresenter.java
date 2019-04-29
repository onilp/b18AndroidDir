package com.example.uitest.main;

public class MainPresenter implements MainContract.Presenter {//1 --- //5

    MainContract.View view;//switch board //8
    public MainPresenter(MainActivity mainActivity) {//7
        view = mainActivity;//8a
    }

    @Override
    public void onButtonClicked() {
        //hey mr view set this text
        view.setText("abdul");//8b

    }

    @Override
    public void listItemClicked(String name) {
        //hey ms view show a toast
        view.showToast("presenter:  "+name);
    }
}
