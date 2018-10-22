/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.interaction;

import com.acidmanic.consoletools.terminal.Terminal;
import com.acidmanic.consoletools.terminal.styling.TerminalStyle;
import com.acidmanic.consoletools.terminal.styling.TerminalStyles;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class StyledTextInput extends TextInput{
    
    
    private TerminalStyle labelStyle = TerminalStyles.Matrix;
    private TerminalStyle valueStyle = TerminalStyles.BlueInput;

    @Override
    public String askInput() {
        Terminal terminal = new Terminal();
        terminal.setScreenAttributes(labelStyle);
        printLabel();
        terminal.setScreenAttributes(valueStyle);
        String res = getStringInputOrDefault();
        terminal.resetScreenAttributes();
        return res;
    }

    public StyledTextInput(String label, String value) {
        super(label, value);
    }

    public StyledTextInput(String label) {
        super(label);
    }

    public StyledTextInput() {
    }

    public TerminalStyle getLabelStyle() {
        return labelStyle;
    }

    public void setLabelStyle(TerminalStyle labelStyle) {
        this.labelStyle = labelStyle;
    }

    public TerminalStyle getValueStyle() {
        return valueStyle;
    }

    public void setValueStyle(TerminalStyle valueStyle) {
        this.valueStyle = valueStyle;
    }
    
    
    
    
    
}
