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
package com.acidmanic.consoletools.terminal;

import com.acidmanic.consoletools.terminal.styling.TerminalControlEscapeSequences;
import com.acidmanic.consoletools.terminal.styling.TerminalStyle;
import com.acidmanic.consoletools.terminal.styling.TerminalCommandBuilder;
import com.acidmanic.consoletools.drawing.Size;
import java.io.PrintStream;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Terminal {

    private static final String ESCAPE_S = String.format("%s", TerminalControlEscapeSequences.ESCAPE);
    private final PrintStream out;

    public final class Constants extends TerminalControlEscapeSequences{}
    
    
    public Terminal() {
        this.out = System.out;
    }

    public Terminal(PrintStream out) {
        this.out = out;
    }

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

    public void setScreenAttributes(TerminalStyle style) {
        String command = new TerminalCommandBuilder().createAttributesCommand(style);
        executeOnTerminal(command);
    }

    public void resetScreenAttributes() {
        String command = new TerminalCommandBuilder().resetScreenAttributes();
        executeOnTerminal(command);
    }

    private void executeOnTerminal(String command) {
        try {
            this.out.write(command.getBytes());
        } catch (Throwable ex) {
        }
    }

    public void moveCursor(Size positionChange) {
        moveCursorVertically(positionChange.getLines());
        moveCursorHorizontally(positionChange.getColumns());
    }

    private void moveCursorVertically(int lines) {
        if (lines < 0) {
            executeOnTerminal(new TerminalCommandBuilder().moveCursorUp(-lines));
        } else {
            executeOnTerminal(new TerminalCommandBuilder().moveCursorDown(lines));
        }
    }

    private void moveCursorHorizontally(int columns) {
        if (columns < 0) {
            executeOnTerminal(new TerminalCommandBuilder().moveCursorLeft(-columns));
        } else {
            executeOnTerminal(new TerminalCommandBuilder().moveCursorRight(columns));
        }
    }

}
