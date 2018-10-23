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
package com.acidmanic.consoletools.textualcontent;

import com.acidmanic.consoletools.textualcontent.builtin.BuiltinStringModifierPriority;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class StringModifierManager {

    private final HashMap<String, Integer> modifersIndexes;
    private final ArrayList<StringModifier> modifiers;
    private final StringModifierPriority priority;

    public StringModifierManager() {
        this(new BuiltinStringModifierPriority());
    }

    public StringModifierManager(StringModifierPriority priority) {
        this.priority = priority;
        this.modifersIndexes = new HashMap<>();
        this.modifiers = new ArrayList<>();
    }

    public void setModifier(StringModifier modifier) {
        String key = modifier.getClass().getName();
        removeModifierIfExists(key);
        addModifier(key, modifier);
    }

    private void addModifier(String key, StringModifier modifier) {
        this.modifersIndexes.put(key, modifiers.size());
        this.modifiers.add(modifier);
    }

    private void removeModifierIfExists(String key) {
        if (this.modifersIndexes.containsKey(key)) {
            int index = this.modifersIndexes.get(key);
            this.modifiers.remove(index);
            this.modifersIndexes.remove(key);

        }
    }

    public void removeModifier(Class type) {
        removeModifierIfExists(type.getName());
    }

    public String applyAll(String value) {
        sortByPriority();
        String ret = value;
        for (StringModifier modifier : this.modifiers) {
            ret = modifier.process(ret);
        }
        return ret;
    }

    private void sortByPriority() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < this.modifiers.size() - 1; i++) {
                if (this.priority.compare(this.modifiers.get(i),
                        this.modifiers.get(i + 1))) {
                    isSorted = false;
                    swapModifiers(i, i + 1);
                }
            }
        }
    }

    private void swapModifiers(int i1, int i2) {
        String keyWrapped = this.modifiers.get(i1).getClass().getName();
        String keyWrapper = this.modifiers.get(i2).getClass().getName();
        this.modifersIndexes.remove(keyWrapped);
        this.modifersIndexes.remove(keyWrapper);
        this.modifersIndexes.put(keyWrapper, i1);
        this.modifersIndexes.put(keyWrapped, i2);
        StringModifier temp = this.modifiers.get(i1);
        this.modifiers.set(i1, this.modifiers.get(i2));
        this.modifiers.set(i2, temp);
    }

    
    
}
