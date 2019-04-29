package com.example.recyclerviewinfragment;

import android.support.v4.app.Fragment;

import java.util.List;

public interface MainContract {

    interface View{
        void redirectToDisplayFragment(Fragment displayFragment);
        void setDataToAdapter(List<UsersModel> userList);
    }

    interface Presenter{

        void addUsers(List<UsersModel> userList);
        void clickedData(String name, String age);
    }
}
