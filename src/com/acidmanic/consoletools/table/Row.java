/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.rendering.Box;
import java.util.ArrayList;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Row {

    ArrayList<Box> cells;

    public Row() {
        this.cells = new ArrayList<>();

    }

    public ArrayList<Box> getCells() {
        return cells;
    }

}
