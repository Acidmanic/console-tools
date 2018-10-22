/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering.sizing;

import com.acidmanic.consoletools.rendering.componentfeatures.Renderable;
import com.acidmanic.consoletools.drawing.Size;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class SizeAutomation {

    public static final int WRAP_CONTENT = -1;

    private int columns = WRAP_CONTENT;
    private int lines = WRAP_CONTENT;

    public SizeAutomation() {
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
    
    
    
    public Size measure(Renderable renderable){
        if(columns!=WRAP_CONTENT&&lines!=WRAP_CONTENT){
            return new Size(columns, lines);
        }
        Size measured = renderable.measure();
        int c = columns==WRAP_CONTENT?measured.getColumns():columns;
        int l = lines==WRAP_CONTENT?measured.getLines():lines;
        return new Size(c,l);
    }
}
