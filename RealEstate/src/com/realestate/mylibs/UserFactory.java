/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realestate.mylibs;
import com.realestate.mylibs.User;
import java.util.HashMap;
import java.util.Map;

public class UserFactory {
    private static UserFactory instance;
    private Map<String, User> users = new HashMap<>();

    private UserFactory() {}

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }

    public boolean registerUser(String username, String fullName, String contact, String address, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        User newUser = new User(username, fullName, contact, address, password);
        users.put(username, newUser);
        return true;
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
