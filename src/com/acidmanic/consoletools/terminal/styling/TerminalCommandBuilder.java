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
package com.acidmanic.consoletools.terminal.styling;

import static com.acidmanic.consoletools.terminal.styling.TerminalControlEscapeSequences.ESCAPE;

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

    public String setScreenColors(int foreground, int background, int brightness) {
        String command = String.format("%s[%d;%d;%dm",
                ESCAPE, foreground, background, brightness);
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

    public String moveCursorUp(int rows) {
        return String.format("%s[%dA", ESCAPE, rows);
    }
    
    public String moveCursorDown(int rows) {
        return String.format("%s[%dB", ESCAPE, rows);
    }

    public String moveCursorRight(int columns) {
        return String.format("%s[%dC", ESCAPE, columns);
    }
    
    public String moveCursorLeft(int columns) {
        return String.format("%s[%dD", ESCAPE, columns);
    }
}
