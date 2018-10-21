/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.textualcontent.builtin;

import com.acidmanic.consoletools.textualcontent.StringModifier;
import com.acidmanic.consoletools.textualcontent.StringModifierPriority;
import java.util.HashMap;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class BuiltinStringModifierPriority implements StringModifierPriority{

    private final HashMap<String, Integer> priorities;

    public BuiltinStringModifierPriority() {
        this.priorities=new HashMap<>();
        
        setPriority(TextWrapperStringModifier.class);
        setPriority(DoNothingStringModifier.class);
    }

    private void setPriority(Class type) {
        this.priorities.put(type.getName(), this.priorities.size());
    }
    
    private int getPriority(Class type){
        String key = type.getName();
        if(this.priorities.containsKey(key)){
            return this.priorities.get(key);
        }
        return -1;
    }
    @Override
    public boolean compare(StringModifier wraps, StringModifier isBeeingWrapped) {
        return getPriority(isBeeingWrapped.getClass()) 
                >
                getPriority(wraps.getClass());
    }
    
}
