package com.example.uitest.main;

public interface MainContract {//2

    /**
     * presenter  tells the view to do.
     */
    interface View{//2a
        public void setText(String message);//3a

        void showToast(String name);
    }

    /**
     * view tell to the presenter
     */
    interface Presenter{//2b
        public  void onButtonClicked();//3b

        void listItemClicked(String name);
    }

}
