/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Size {
    private int columns;
    private int lines;

    public Size() {
        this.columns=0;
        this.lines=0;
    }

    public Size(int columns, int lines) {
        this.columns = columns;
        this.lines = lines;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public Size add(Size size) {
        return new Size(this.columns+size.columns,this.lines+size.lines);
    }
    
}
