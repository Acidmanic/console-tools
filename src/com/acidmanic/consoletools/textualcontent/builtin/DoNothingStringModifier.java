/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.textualcontent.builtin;

import com.acidmanic.consoletools.textualcontent.StringModifier;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class DoNothingStringModifier implements StringModifier {

    @Override
    public String process(String original) {
        return original;
    }

}
