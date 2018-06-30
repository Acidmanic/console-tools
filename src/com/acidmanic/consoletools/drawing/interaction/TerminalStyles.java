/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing.interaction;

import static com.acidmanic.consoletools.drawing.interaction.TerminalControlEscapeSequences.*;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TerminalStyles {
    @SuppressWarnings(value = "Naming")
    public static final TerminalStyle Matrix = new TerminalStyle(FOREGROUND_GREEN, BACKGROUND_BLACK);
    public static final TerminalStyle Error = new TerminalStyle(FOREGROUND_RED, BACKGROUND_BLACK);
    public static final TerminalStyle BIOS = new TerminalStyle(FOREGROUND_WHITE, BACKGROUND_BLACK);
    public static final TerminalStyle UglyMac = new TerminalStyle(FOREGROUND_BLACK, BACKGROUND_WHITE);
}
