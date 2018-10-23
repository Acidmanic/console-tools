/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.interaction;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * @param <T> returning type of input
 */
public abstract class Input<T> {

    protected T value;
    private String label;

    public Input(String label, T value) {
        this.value = value;
        this.label = label;
    }

    public Input(String label) {
        this.label = label;
    }

    public Input() {
    }

    protected void printLabel() {
        System.out.println();
        System.out.print(label);
        String valueString = getStringForValue();
        if (valueString != null && !valueString.isEmpty()) {
            System.out.print(" (" + this.getStringForValue() + ")");
        }
        System.out.println(":");
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
            return System.in.read();
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
