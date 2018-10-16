/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.terminal;

import static com.acidmanic.consoletools.terminal.TerminalControlEscapeSequences.*;

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
