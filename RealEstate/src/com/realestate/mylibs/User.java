/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realestate.mylibs;
public class User {
    private String username;
    private String fullName;
    private String contact;
    private String address;
    private String password;

    public User(String username, String fullName, String contact, String address, String password) {
        this.username = username;
        this.fullName = fullName;
        this.contact = contact;
        this.address = address;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
