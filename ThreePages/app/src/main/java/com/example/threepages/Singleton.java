package com.example.threepages;

import java.util.ArrayList;
import java.util.List;

public class Singleton {

    private static Singleton single_instance = null;

    public List<Users> usersList;

    public static Singleton getInstance() {
        if(single_instance == null){
            single_instance = new Singleton();
        }
        return single_instance;
    }

    private Singleton() {
        usersList = new ArrayList<>();
    }

    public List<Users> getUserList(){
        return this.usersList;
    }

    public void addToList(String username){
        usersList.add(new Users(username));
    }

}
