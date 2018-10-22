/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.string;

import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.string.StringExtensions;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class StringMeasurer {

    public StringMeasurer() {
    }

    public Size getSize(String content) {
        String[] lines = StringExtensions.split(content, "\n");

        int maxWidth = 0;
        for (String line : lines) {
            if (line.length() > maxWidth) {
                maxWidth = line.length();
            }
        }
        return new Size(maxWidth, lines.length);
    }

    public Size getSize(String content, Padding padding) {
        Size size = getSize(content);
        size.setColumns(size.getColumns() + padding.getLeft() + padding.getRight());
        size.setLines(size.getLines() + padding.getTop() + padding.getBottom());
        return size;
    }

}
