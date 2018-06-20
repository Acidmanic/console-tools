/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools;

import java.util.Stack;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class BufferedStringRenderingContext implements StringRenderingContext {

    private final char[][] buffer;
    private final Size size;
    private final Stack<Clip> clipStack;
    
    private Clip currentClip;
    
    
    private int currentCol;
    private int currentLine;

    public BufferedStringRenderingContext(Size size) {
        buffer = new char[size.getLines()][size.getColumns()];
        clipStack = new Stack<>();
        this.size = size;
        this.currentClip = new Clip(0, size.getColumns(), 0, size.getLines());
        
        
        reset();
    }

    @Override
    public String renrerAll() {
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < buffer.length; l++) {
            for (int c = 0; c < buffer[l].length; c++) {
                sb.append(this.buffer[l][c]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void put(String string) {
        String[] lines = string.split("\\n");
        for (int l = 0; l < lines.length; l++) {
            int lineNumber = l + this.currentLine;
            if (validLine(lineNumber)) {
                for (int c = 0; c < lines[l].length(); c++) {
                    int columnNumber = c + this.currentCol;
                    if (validColumn(columnNumber)) {
                        this.buffer[lineNumber][columnNumber]
                                = lines[l].charAt(c);
                    }
                }
            }
        }
    }

    @Override
    public void moveHorozontally(int columns) {
        this.currentCol += columns;
    }

    @Override
    public void resetHorizontally() {
        this.currentCol = this.currentClip.getStartColumn();
    }

    @Override
    public final void reset() {
        this.currentCol = this.currentClip.getStartColumn();
        this.currentLine = this.currentClip.getStartLine();
        for (int i = 0; i < buffer.length; i++) {
            for (int j = 0; j < buffer[i].length; j++) {
                buffer[i][j] = ' ';
            }
        }
    }

    @Override
    public void moveVertically(int lines) {
        this.currentLine += lines;
    }

    private boolean validLine(int lineNumber) {
        return lineNumber >= 0 && lineNumber < this.size.getLines();
    }

    private boolean validColumn(int columnNumber) {
        return columnNumber >= 0 && columnNumber < this.size.getColumns();
    }

    @Override
    public Position getCurrentPosition() {
        Position pos = new Position();
        pos.setColumns(currentCol);
        pos.setLines(currentLine);
        return pos;
    }

    @Override
    public void pushClip(Clip clip) {
        this.clipStack.push(this.currentClip);
        this.currentClip = clip;
    }

    @Override
    public Clip popClip() {
        Clip lastOne = this.currentClip;
        this.currentClip = this.clipStack.pop();
        return lastOne;
    }

    @Override
    public void resetVertically() {
        this.currentLine = this.currentClip.getStartLine();
    }

}
