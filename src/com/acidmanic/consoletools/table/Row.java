/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.Renderable;
import java.util.ArrayList;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Row {

    ArrayList<Renderable> cells;

    public Row() {
        this.cells = new ArrayList<>();

    }

    public ArrayList<Renderable> getCells() {
        return cells;
    }

}
