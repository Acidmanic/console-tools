/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
