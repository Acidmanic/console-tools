/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.textualcontent.builtin;

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

    private String wrapIfNeeded(String line) {
        StringBuilder ret = new StringBuilder();
        String[] words = line.split("\\s");
        int width = 0;
        String sep = "";
        for (String word : words) {
            if (width + word.length() >= this.maximumWidth) {
                while (word.length() > this.maximumWidth) {
                    String starter = word.substring(0, this.maximumWidth);
                    word = word.substring(this.maximumWidth, word.length());
                    ret.append(sep).append(starter);
                }
                width = 0;
                ret.append("\n");
                sep = "";
            }
            ret.append(sep).append(word);
            width += word.length();
            sep = " ";
        }
        return ret.toString();
    }
}
