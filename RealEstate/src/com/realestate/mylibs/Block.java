/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.realestate.mylibs;

import java.util.ArrayList;
import java.util.List;

public class Block {
    
    private String blockName;
    private List<Lot> lots;

    public Block(String blockName) {
        this.blockName = blockName;
        this.lots = new ArrayList<>();
    }

    public void addLot(Lot lot) {
        lots.add(lot);
    }

    public List<Lot> getLots() {
        return lots;
    }

    public String getBlockName() {
        return blockName;
    }
}

