/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing.interaction;

import com.acidmanic.consoletools.drawing.Size;
import org.junit.Test;
import static org.junit.Assert.*;

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


    
    
}
