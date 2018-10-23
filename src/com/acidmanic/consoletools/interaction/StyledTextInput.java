/* 
 * Copyright (C) 2018 Mani Moayedi (acidmanic.moayedi@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
