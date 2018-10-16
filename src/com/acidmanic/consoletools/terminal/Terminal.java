/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.terminal;

import com.acidmanic.consoletools.drawing.Size;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Terminal {

    private static final String ESCAPE_S = String.format("%s", TerminalControlEscapeSequences.ESCAPE);

    public Size queryCursorPosition() {
        String command = new TerminalCommandBuilder().queryCursorPosition();
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
        String command = new TerminalCommandBuilder().setScreenColors(foreground, background);
        executeOnTerminal(command);
    }

    
    
    public void setScreenAttributes(TerminalStyle style){
        String command = new TerminalCommandBuilder().createAttributesCommand(style);
        executeOnTerminal(command);
    }

    public void resetScreenAttributes(){
        String command = new TerminalCommandBuilder().resetScreenAttributes();
        executeOnTerminal(command);
    }

    
    private void executeOnTerminal(String command) {
        try {
            System.out.write(command.getBytes());
        } catch (Throwable ex) {
        }
    }

    public void moveCursor(Size positionChange){
        moveCursorVertically(positionChange.getLines());
        moveCursorHorizontally(positionChange.getColumns());
    }

    private void moveCursorVertically(int lines) {
        if (lines<0){
            executeOnTerminal(new TerminalCommandBuilder().moveCursorUp(-lines));
        }else{
            executeOnTerminal(new TerminalCommandBuilder().moveCursorDown(lines));
        }
    }

    private void moveCursorHorizontally(int columns) {
        if (columns<0){
            executeOnTerminal(new TerminalCommandBuilder().moveCursorLeft(-columns));
        }else{
            executeOnTerminal(new TerminalCommandBuilder().moveCursorRight(columns));
        }
    }


}
