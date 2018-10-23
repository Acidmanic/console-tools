/* 
 * Copyright (C) 2018 Mani Moayedi (acidmanic.moayedi@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
        return column >= this.startColumn && column <= this.endColumn;
    }

    public boolean containsLine(int line) {
        return line >= this.startLine && line <= this.endLine;
    }

    public int getColumns() {
        return this.endColumn - this.startColumn;
    }

    public int getLines() {
        return this.endLine - this.startLine;
    }

    public Size getSize() {
        return new Size(this.endColumn - this.startColumn, this.endLine - this.startLine);
    }
}
