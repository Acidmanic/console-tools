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
