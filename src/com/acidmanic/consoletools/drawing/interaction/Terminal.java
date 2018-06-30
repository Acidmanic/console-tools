/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing.interaction;

import com.acidmanic.consoletools.drawing.Size;
import static com.acidmanic.consoletools.drawing.interaction.TerminalControlEscapeSequences.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Terminal {

    private static final String ESCAPE_S = String.format("%s", TerminalControlEscapeSequences.ESCAPE);

    public Size queryCursorPosition() {
        String command = String.format("%s[6n", TerminalControlEscapeSequences.ESCAPE);
        try {
            System.out.write(command.getBytes());
            if (System.console() != null) {
                char[] chars = System.console().readPassword();
                String response = new String(chars);
                response = response.replace(ESCAPE_S, "");
                response = response.replace("[", "");
                response = response.replace("R", "");
                String[] rc = response.split(";");
                int r = Integer.parseInt(rc[0]);
                int c = Integer.parseInt(rc[1]);
                return new Size(r, c);
            }
        } catch (Throwable ex) {

        }
        return new Size();
    }

    public void setScreenAttributes(int foreground, int background) {
        String command = String.format("%s[%d;%dm", ESCAPE, foreground, background);
        executeOnTerminal(command);
    }
    
    public void setScreenAttributes(TerminalStyle style){
        String command = createAttributesCommand(style);
        executeOnTerminal(command);
    }

    private void executeOnTerminal(String command) {
        try {
            System.out.write(command.getBytes());
        } catch (Throwable ex) {
        }
    }

    private String createAttributesCommand(TerminalStyle style) {
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

    private String createFontCommand(TerminalStyle style) {
        String command = String.format("%s", ESCAPE);
        command += style.isAlternativeFontUsing()? FONT_MAIN:FONT_ALTERNATIVE;
        return command;
    }

}
