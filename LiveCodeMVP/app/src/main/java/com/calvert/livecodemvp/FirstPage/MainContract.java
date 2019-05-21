package com.calvert.livecodemvp.FirstPage;

public interface MainContract {
    interface View{
        void displayMessage(String msg);
    }

    interface Presenter{
        void onSubmitClicked(String msg);
    }
}
