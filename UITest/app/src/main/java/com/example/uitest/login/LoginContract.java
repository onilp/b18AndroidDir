package com.example.uitest.login;

public interface LoginContract {

    interface View{
        void showAToast(String message);
    }

    interface Presenter{
        void buttonClicked();
    }
}
