/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.terminal;

import static com.acidmanic.consoletools.terminal.TerminalControlEscapeSequences.ESCAPE;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TerminalCommandBuilder {

    public String queryCursorPosition() {
        String command = String.format("%s[6n", TerminalControlEscapeSequences.ESCAPE);
        return command;
    }
    
    public String setScreenColors(int foreground, int background) {
        String command = String.format("%s[%d;%dm", ESCAPE, foreground, background);
        return command;
    }
    
    
    public String setScreenColors(int foreground, int background,int brightness) {
        String command = String.format("%s[%d;%d;%dm", 
                ESCAPE, foreground, background,brightness);
        return command;
    }
    
    public String createAttributesCommand(TerminalStyle style) {
        StringBuilder sb = new StringBuilder();
        sb.append(ESCAPE).append("[");
        String sep = "";
        for (int att : style.getAll()) {
            sb.append(sep).append(att);
            sep = ";";
        }
        sb.append("m");
        return sb.toString();
    }

    public String resetScreenAttributes() {
        String command = String.format("%s[%dm", ESCAPE, TerminalControlEscapeSequences.ATTR_RESET_ALL);
        return command;
    }

    public String setFont(TerminalStyle style) {
        String command = String.format("%s", ESCAPE);
        command += style.isAlternativeFontUsing() ? TerminalControlEscapeSequences.FONT_MAIN : TerminalControlEscapeSequences.FONT_ALTERNATIVE;
        return command;
    }
}
