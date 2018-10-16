/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.playgrounds;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TerminalPlayground {

    
    private final static char ESC = 0x1b;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String mysentence = "this is input";
        ByteArrayInputStream stream = new ByteArrayInputStream(mysentence.getBytes());
        InputStream stdin = System.in;
        System.setIn(stream);
        System.out.write(String.format("%s7", ESC).getBytes());
        System.out.write(mysentence.getBytes());
        
        
        String line;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(stdin))) {
            while ((line = in.readLine()) != null) {
                System.err.println(line);
                System.out.write(String.format("%s8", ESC).getBytes());
            }
        }
    }

}
