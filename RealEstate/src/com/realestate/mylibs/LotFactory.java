/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realestate.mylibs;

import com.realestate.mylibs.Lot;
import com.realestate.mylibs.Block;

public class LotFactory {
    private static LotFactory instance;

    private LotFactory() {}

    public static synchronized LotFactory getInstance() {
        if (instance == null) {
            instance = new LotFactory();
        }
        return instance;
    }

    public Lot createLot(String block, int lotNumber, String size, String location, double price, String status) {
        return new Lot(block, lotNumber, size, location, price, status);
    }

    public Block createBlock(String blockName) {
        return new Block(blockName);
    }
}
