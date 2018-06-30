/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing.interaction;

import com.acidmanic.consoletools.drawing.Size;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.acidmanic.consoletools.drawing.interaction.TerminalControlEscapeSequences.*;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TerminalTest {
    
    public TerminalTest() {
    }

    @Test
    public void testQueryCursorPosition() {
        System.out.println("queryCursorPosition");
        Terminal instance = new Terminal();
        Size expResult = new Size();
        Size result = instance.queryCursorPosition();
        assertEquals(expResult.getColumns(), result.getColumns());
        assertEquals(expResult.getLines(), result.getLines());
    }

    
    @Test
    public void testSetScreenAttributes_TerminalStyle() {
        System.out.println("setScreenAttributes");
        Terminal instance = new Terminal();
        instance.setScreenAttributes(TerminalStyles.Error);
        System.out.println("Sample text for error style.");
        instance.setScreenAttributes(TerminalStyles.BIOS);
        System.out.println("Sample text for Bios style.");
        
        instance.setScreenAttributes(TerminalStyles.Matrix);
        System.out.println("Sample text for MATRIX style.");
        
        instance.setScreenAttributes(TerminalStyles.UglyMac);
        System.out.println("Sample text for UglyMac style.");
        
        TerminalStyle matrix = TerminalStyles.Matrix;
        matrix.setAlternativeFontUsing(true);
        instance.setScreenAttributes(matrix);
        System.out.println("Sample text for ALT MATRIX style.");
        
        assertTrue(true);
    }


    
    
}
