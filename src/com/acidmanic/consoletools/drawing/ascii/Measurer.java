/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing.ascii;

import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.table.Padding;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Measurer {

    public Measurer() {
    }

    public Size getSize(String content) {
        String[] lines = content.split("\\n");

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
