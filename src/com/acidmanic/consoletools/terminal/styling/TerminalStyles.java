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

import static com.acidmanic.consoletools.terminal.styling.TerminalControlEscapeSequences.*;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TerminalStyles {

    @SuppressWarnings(value = "Naming")
    public static final TerminalStyle Matrix
            = new TerminalStyle(FOREGROUND_GREEN, BACKGROUND_BLACK, BRIGHTNESS_BRIGHT);
    public static final TerminalStyle Error = new TerminalStyle(FOREGROUND_RED);
    public static final TerminalStyle Warning 
            = new TerminalStyle(FOREGROUND_YELLOW,TerminalStyle.VALUE_UNSET,BRIGHTNESS_DIM);
    public static final TerminalStyle BIOS
            = new TerminalStyle(FOREGROUND_WHITE, BACKGROUND_BLACK, BRIGHTNESS_BRIGHT);
    public static final TerminalStyle UglyMac
            = new TerminalStyle(FOREGROUND_BLACK, BACKGROUND_WHITE, BRIGHTNESS_DIM);
    public static final TerminalStyle BlueInput = new TerminalStyle(FOREGROUND_BLUE);
}
