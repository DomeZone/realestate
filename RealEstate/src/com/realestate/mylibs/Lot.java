/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realestate.mylibs;

import java.util.ArrayList;
import java.util.List;

public class Lot {
    private String block;
    private int lotNumber;
    private String size;
    private String location;
    private double price;
    private String status;

    public Lot(String block, int lotNumber, String size, String location, double price, String status) {
        this.block = block;
        this.lotNumber = lotNumber;
        this.size = size;
        this.location = location;
        this.price = price;
        this.status = status;
    }

    // Getters
    public String getBlock() { return block; }
    public int getLotNumber() { return lotNumber; }
    public String getSize() { return size; }
    public String getLocation() { return location; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }
}

 