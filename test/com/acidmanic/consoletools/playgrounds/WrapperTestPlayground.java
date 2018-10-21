/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.playgrounds;

import com.acidmanic.consoletools.textualcontent.builtin.TextWrapperStringModifier;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class WrapperTestPlayground {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text = ("This should be formatted correctly.\n"
                + "\tline One.\n"
                + "\tline two.\n"
                + "and description after two lines");

        TextWrapperStringModifier wrapper = new 
            TextWrapperStringModifier(15);
        
        analyzePrint(wrapper.process(text));
    }

    private static void analyzePrint(String content) {
        String[] lines = content.split("\\n");
        for(String line:lines){
            System.out.print(line.length());
            System.out.print("\t");
            System.out.println(line);
        }
    }
    
}
