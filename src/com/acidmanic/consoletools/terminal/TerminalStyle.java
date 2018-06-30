/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.terminal;

import java.util.ArrayList;
import java.util.List;
import static com.acidmanic.consoletools.terminal.TerminalControlEscapeSequences.*;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TerminalStyle {

    public static final int VALUE_UNSET = -1;
    private int foregroundColor;
    private int backgroundColor;
    private int brightness;
    private final List<Integer> properties;
    private boolean alternativeFontUsing;

    public TerminalStyle() {
        this.properties = new ArrayList<>();
        this.properties.add(TerminalControlEscapeSequences.ATTR_RESET_ALL);
        this.brightness = VALUE_UNSET;
        this.foregroundColor = VALUE_UNSET;
        this.backgroundColor = VALUE_UNSET;
        this.alternativeFontUsing = false;
    }

    public TerminalStyle(int foreground, int background) {
        this();
        this.foregroundColor = foreground;
        this.backgroundColor = background;

    }

    public TerminalStyle(int foregroundColor, int backgroundColor, int brightness) {
        this();
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.brightness = brightness;
    }

    
    public int getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(int foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void addAttributes(int attribute) {
        this.properties.add(attribute);
    }

    public List<Integer> getAll() {
        ArrayList<Integer> ret = new ArrayList<>(this.properties);
        addIfSet(ret,this.backgroundColor);
        addIfSet(ret,this.foregroundColor);
        addIfSet(ret,this.brightness);
        return ret;
    }

    private void addIfSet(ArrayList<Integer> ret,int value) {
        if (value != VALUE_UNSET) {
            ret.add(value);
        }
    }

        
    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness == BRIGHTNESS_BRIGHT || brightness == BRIGHTNESS_DIM) {
            this.brightness = brightness;

        }
    }

    public boolean isAlternativeFontUsing() {
        return alternativeFontUsing;
    }

    public void setAlternativeFontUsing(boolean alternativeFontUsing) {
        this.alternativeFontUsing = alternativeFontUsing;
    }

    
    public void unsetForeground(){
        this.foregroundColor=VALUE_UNSET;
    }
    public void unsetBackground(){
        this.backgroundColor=VALUE_UNSET;
    }
    public void unsetBrightness(){
        this.brightness=VALUE_UNSET;
    }
}
