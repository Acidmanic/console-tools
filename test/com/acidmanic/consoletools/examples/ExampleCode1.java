/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.examples;

import com.acidmanic.consoletools.terminal.Terminal;
import com.acidmanic.consoletools.terminal.styling.TerminalStyle;
import com.acidmanic.consoletools.terminal.styling.TerminalStyles;

/**
 *
 * Example Code for Printing Styled text
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class ExampleCode1 {

    public static void main(String[] args) {

        Terminal terminal = new Terminal();

        /* Print Black Text on Red background */
        
        terminal.setScreenAttributes(Terminal.Constants.FOREGROUND_BLACK,
                Terminal.Constants.BACKGROUND_RED);
        
        System.out.println("Black Text On Red Background");

        /* Print Styled Text using Style class */
        
        TerminalStyle style = new TerminalStyle(Terminal.Constants.FOREGROUND_WHITE, 
                Terminal.Constants.BACKGROUND_BLUE, 
                Terminal.Constants.BRIGHTNESS_DIM);
        
        terminal.setScreenAttributes(style);
        
        System.out.println("A dim white text printed on blue background");
        
        /* Using built-in styles */
        
        terminal.setScreenAttributes(TerminalStyles.Matrix);
        
        System.out.println("Matrix like text, using built-in styles");
        
        
        /* Print On Other Stream (In this case: System.err) */
        
        terminal = new Terminal(System.err);
        
        terminal.setScreenAttributes(TerminalStyles.Matrix);
        
        System.err.println("Matrix like text, using built-in styles");
        
        
    }

}
