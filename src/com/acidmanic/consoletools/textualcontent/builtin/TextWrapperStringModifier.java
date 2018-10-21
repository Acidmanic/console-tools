/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.textualcontent.builtin;

import com.acidmanic.consoletools.string.StringExtensions;
import com.acidmanic.consoletools.textualcontent.StringModifier;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TextWrapperStringModifier implements StringModifier {

    private final int maximumWidth;

    public TextWrapperStringModifier(int forcedWidth) {
        this.maximumWidth = forcedWidth;
    }

    private String devide(String part, StringBuilder sb) {
        while (part.length() > this.maximumWidth) {
            String starter = part.substring(0, this.maximumWidth);
            part = part.substring(this.maximumWidth, part.length());
            sb.append(starter).append("\n");
        }
        return part;
    }

    private String wrapIfNeeded(String line) {
        StringBuilder ret = new StringBuilder();
        String[] parts = StringExtensions.splitPreserving(line, "(\\s|\\.|;|,|-)");
        int width = 0;
        for (String part : parts) {
            if (width + part.length() > this.maximumWidth) {
                width = 0;
                ret.append("\n");
            }
            part = devide(part, ret);
            ret.append(part);
            width += part.length();
        }
        return ret.toString();
    }

    @Override
    public String process(String original) {
        String lines[] = original.split("\\n");
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (String line : lines) {
            line = wrapIfNeeded(line);
            sb.append(sep).append(line);
            sep = "\n";
        }
        return sb.toString();
    }
}
