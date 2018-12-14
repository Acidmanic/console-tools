/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing.interaction;

import com.acidmanic.consoletools.interaction.TextInput;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TextInputTest {
    
    public TextInputTest() {
        
    }

    @Test
    public void testAskInput() {
        System.out.println("askInput");
        TextInput instance = new TextInput("Please just hit Enter","Default");
        instance.setIn(new PrefillableInputStream("\n"));
        String expResult = "Default";
        String result = instance.askInput();
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testAskInputNull() {
        System.out.println("askInput");
        TextInput instance = new TextInput("Please just hit Enter");
        instance.setIn(new PrefillableInputStream("\n"));
        String expResult = "";
        String result = instance.askInput();
        assertEquals(expResult, result);
    }
    
}
