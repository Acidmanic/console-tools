/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.textualcontent.builtin;

import com.acidmanic.consoletools.drawing.HorizontalAlignment;
import com.acidmanic.consoletools.textualcontent.Content;
import com.acidmanic.consoletools.textualcontent.ContentModifier;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class HorizontalAlignerContentModifier extends ContentModifier {

    private final HorizontalAlignment alignment;

    public HorizontalAlignerContentModifier(Content innerContent) {
        super(innerContent);
        this.alignment = HorizontalAlignment.Left;
    }

    public HorizontalAlignerContentModifier(HorizontalAlignment alignment, Content innerContent) {
        super(innerContent);
        this.alignment = alignment;
    }

    @Override
    public String getContent() {
        String content = this.getInnerContent().getContent();
        String[] lines = content.split("\\n");
        String sep = "\n";
        int width = 0;
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            if (line.length() > width) {
                width = line.length();
            }
        }
        for (String line : lines) {
            line = align(line, width);
            sb.append(sep).append(line);
            sep = "\n";
        }
        return sb.toString();
    }

    private String align(String line, int width) {
        String lineContent = line.trim();
        int spaces = width = lineContent.length();
        if (spaces < 0) {
            spaces = 0;
        }
        return getLeftSpaces(spaces)
                + lineContent
                + getRightSpaces(spaces);
    }

    private String getLeftSpaces(int width) {
        if (this.alignment == HorizontalAlignment.Right) {
            return "";
        }
        if (this.alignment == HorizontalAlignment.Left) {
            return makeString(" ", width);
        }
        return makeString(" ", getLefthalf(width));
    }

    private String makeString(String value, int width) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            sb.append(value);
        }
        return sb.toString();
    }

    private int getLefthalf(int width) {
        return (int) (Math.floorDiv(width, 2));
    }

    private String getRightSpaces(int width) {
        if (this.alignment == HorizontalAlignment.Left) {
            return "";
        }
        if (this.alignment == HorizontalAlignment.Right) {
            return makeString(" ", width);
        }
        return makeString(" ", width - getLefthalf(width));
    }

}
