/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing.interaction;

import java.util.ArrayList;
import java.util.List;
import static com.acidmanic.consoletools.drawing.interaction.TerminalControlEscapeSequences.*;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TerminalStyle {

    private int foregroundColor = FOREGROUND_WHITE;
    private int backgroundColor = BACKGROUND_BLACK;
    private int brightness ;
    private final List<Integer> properties;
    private boolean alternativeFontUsing;

    public TerminalStyle() {
        this.properties = new ArrayList<>();
        this.properties.add(TerminalControlEscapeSequences.ATTR_RESET_ALL);
        this.brightness = ATTR_BRIGHT;
        this.alternativeFontUsing = false;
    }

    public TerminalStyle(int foreground, int background) {
        this();
        this.foregroundColor = foreground;
        this.backgroundColor = background;
        
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
        ret.add(foregroundColor);
        ret.add(backgroundColor);
        ret.add(this.brightness);
        return ret;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness == ATTR_BRIGHT || brightness == ATTR_DIM) {
            this.brightness = brightness;

        }
    }

    public boolean isAlternativeFontUsing() {
        return alternativeFontUsing;
    }

    public void setAlternativeFontUsing(boolean alternativeFontUsing) {
        this.alternativeFontUsing = alternativeFontUsing;
    }
    
    

}
