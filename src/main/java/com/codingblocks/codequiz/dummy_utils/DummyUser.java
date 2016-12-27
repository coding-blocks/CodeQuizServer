package com.codingblocks.codequiz.dummy_utils;

import com.codingblocks.codequiz.models.User;

import java.util.ArrayList;

/**
 * Created by piyush0 on 27/12/16.
 */
public class DummyUser {


    public static ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();

        users.add(new User("Piyush",50,"123@gmail.com"));
        users.add(new User("User2",30,"234@gmail.com"));
        users.add(new User("User3",70,"453@gmail.com"));
        users.add(new User("User4",100,"dfsv@gmail.com"));
        users.add(new User("User5",35,"asdfv@gmail.com"));
        users.add(new User("User6",234,"asdfv@gmail.com"));

        return users;
    }
}
