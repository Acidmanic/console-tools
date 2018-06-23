/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.playgrounds;

import com.acidmanic.consoletools.textualcontent.builtin.RawStringContent;
import com.acidmanic.consoletools.textualcontent.builtin.TextWrapperContentModifier;

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
        //text = "This is a long line";
        RawStringContent content = new RawStringContent(text);
        TextWrapperContentModifier wrapper = new 
            TextWrapperContentModifier(15, content);
        
        analyzePrint(wrapper.getContent());
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
