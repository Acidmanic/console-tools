/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing.interaction;


/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TextInput extends Input<String> {

    @Override
    public String askInput() {
        printLabel();
        return getStringInputOrDefault();
    }
    
}
