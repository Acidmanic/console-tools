/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.textualcontent.builtin;

import com.acidmanic.consoletools.string.StringExtensions;
import com.acidmanic.consoletools.textualcontent.Content;
import com.acidmanic.consoletools.textualcontent.ContentModifier;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TextWrapperContentModifier extends ContentModifier {

    private final int maximumWidth;

    public TextWrapperContentModifier(int forcedWidth, Content innerContent) {
        super(innerContent);
        this.maximumWidth = forcedWidth;
    }

    @Override
    public String getContent() {
        String content = this.getInnerContent().getContent();
        String lines[] = content.split("\\n");
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (String line : lines) {
            line = wrapIfNeeded(line);
            sb.append(sep).append(line);
            sep = "\n";
        }
        return sb.toString();
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
            part=devide(part, ret);
            ret.append(part);
            width += part.length();
        }
        return ret.toString();
    }
}
