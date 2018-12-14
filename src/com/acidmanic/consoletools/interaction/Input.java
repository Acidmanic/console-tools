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
package com.acidmanic.consoletools.interaction;

import java.io.InputStream;
import java.io.PrintStream;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * @param <T> returning type of input
 */
public abstract class Input<T> {

    protected T value;
    private String label;
    protected PrintStream out;
    protected InputStream in;
    
    
    public Input(String label, T value) {
        this();
        this.value = value;
        this.label = label;
    }

    public Input(String label) {
        this();
        this.label = label;
    }

    public Input() {
        this.out = System.out;
        this.in = System.in;
    }

    protected void printLabel() {
        this.out.println();
        this.out.print(label);
        String valueString = getStringForValue();
        if (valueString != null && !valueString.isEmpty()) {
            this.out.print(" (" + this.getStringForValue() + ")");
        }
        this.out.println(":");
    }

    protected String getStringForValue() {
        if (this.value == null) {
            return "";
        }
        return value.toString();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    protected int tryReadChar() {
        try {
            return this.in.read();
        } catch (Exception e) {
        }
        return -1;
    }

    protected String readLine() {
        int ch;
        StringBuilder sb = new StringBuilder();
        while ((ch = tryReadChar()) != -1 && ch != '\n') {
            sb.append((char) ch);
        }
        return sb.toString();
    }

    protected String getStringInputOrDefault() {
        String res = readLine();
        if (res == null || res.isEmpty()) {
            return getStringForValue();
        }
        return res;
    }

    public abstract T askInput();
}
