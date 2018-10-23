/* 
 * Copyright (C) 2018 Mani Moayedi (acidmanic.moayedi@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
