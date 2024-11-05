/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realestate.mylibs;

public class Authenticator {
    private UserFactory userFactory = UserFactory.getInstance();

    public boolean login(String username, String password) {
        User user = userFactory.getUser(username);
        return user != null && user.getPassword().equals(password);
    }
}
