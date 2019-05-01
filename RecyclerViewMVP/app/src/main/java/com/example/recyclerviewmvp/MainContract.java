package com.example.recyclerviewmvp;

import java.util.List;

public class MainContract {
    interface View{
        void addToList();

        void showToast(String name);

    }

    interface Presenter{
        void listItemClicked(String name);
    }
}
