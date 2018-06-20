/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing.ascii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class LinedText extends ArrayList<ArrayList<String>> {

    public LinedText(List<String> content) {
        for (String value : content) {
            String[] lines = value.split("\\n");
            ArrayList<String> linedValue = new ArrayList<>();
            linedValue.addAll(Arrays.asList(lines));
            this.add(linedValue);
        }
    }

    public String getLine(int itemNumber, int lineNumber) throws Exception {
        if (itemNumber >= 0 && itemNumber < this.size()) {
            List<String> item = this.get(itemNumber);
            if (lineNumber >= 0 && lineNumber < item.size()) {
                return item.get(lineNumber);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public String tryGetLine(int itemNumber, int lineNumber, String defaultValue) {
        try {
            return getLine(itemNumber, lineNumber);
        } catch (Exception e) {
        }
        return defaultValue;
    }

    public int getNumberOfLines() {
        int ret =0;
        for(List<String> item:this){
            if (item.size()>ret){
                ret  = item.size();
            }
        }
        return ret;
    }

    public int getWidth(int i) {
        List<String> item = this.get(i);
        int width =0;
        for(String line:item){
            if(line.length()>width){
                width = line.length();
            }
        }
        return width;
    }

    public String getItemText(int i) {
        StringBuilder sb = new StringBuilder();
        this.get(i).forEach(line->sb.append(line).append("\n"));
        return sb.toString().trim();
    }

}
