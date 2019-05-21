package com.calvert.livecodemvpagain.Main.FirstPage;

public interface MainContract {
    interface View{
        void displayMessage(String msg);
    }

    interface Presenter{
        void onSubmitClick(String msg);
    }
}
