/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class StringPadder {

    public StringPadder() {
    }

    public String pad(String content, Padding padding) {
        String[] lines = content.split("\n");
        StringBuilder sb = new StringBuilder();
        appendString(sb, '\n', padding.getTop());
        String sep = "";
        for (String line : lines) {
            sb.append(sep);
            appendString(sb, ' ', padding.getLeft())
                    .append(line);
            appendString(sb, ' ', padding.getRight());
            sep="\n";
        }
        appendString(sb, '\n', padding.getBottom());
        return sb.toString();
    }

    private String getString(char c, int number) {
        StringBuilder sb = new StringBuilder(number);
        appendString(sb, c, number);
        return sb.toString();
    }

    private StringBuilder appendString(StringBuilder sb, char c, int number) {
        for (int i = 0; i < number; i++) {
            sb.append(c);
        }
        return sb;
    }

}
