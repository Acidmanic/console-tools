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
public class Clip {

    private int startColumn;
    private int endColumn;
    private int startLine;
    private int endLine;

    public Clip() {
        this.startColumn = 0;
        this.endColumn = 0;
        this.startLine = 0;
        this.endLine = 0;
    }

    public Clip(int startColumn, int endColumn, int startLine, int endLine) {
        this.startColumn = startColumn;
        this.endColumn = endColumn;
        this.startLine = startLine;
        this.endLine = endLine;
    }

    public Clip(Position position, Size size) {
        this.startColumn = position.getColumns();
        this.endColumn = position.getColumns() + size.getColumns();
        this.startLine = position.getLines();
        this.endLine = position.getLines() + size.getLines();
    }

    public int getStartColumn() {
        return startColumn;
    }

    public void setStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }

    public int getEndColumn() {
        return endColumn;
    }

    public void setEndColumn(int endColumn) {
        this.endColumn = endColumn;
    }

    public int getStartLine() {
        return startLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public void setEndLine(int endLine) {
        this.endLine = endLine;
    }

    public boolean containsColumn(int column) {
        return column >=this.startColumn && column <= this.endColumn;
    }

    
    public boolean containsLine(int line) {
        return line >=this.startLine && line <= this.endLine;
    }
}
