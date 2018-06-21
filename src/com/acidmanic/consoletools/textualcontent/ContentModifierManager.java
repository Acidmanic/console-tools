/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.textualcontent;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class ContentModifierManager {

    private final HashMap<String, Integer> modifersIndexes;
    private final ArrayList<ContentModifier> modifiers;

    public ContentModifierManager() {
        this.modifersIndexes = new HashMap<>();
        this.modifiers = new ArrayList<>();
    }

    public void setModifier(ContentModifier modifier) {
        String key = modifier.getClass().getName();
        removeModifierIfExists(key);
        addModifier(key, modifier);
    }

    private void addModifier(String key, ContentModifier modifier) {
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

    public void removeModifier(Class type){
        removeModifierIfExists(type.getName());
    }
    
    public Content applyAll(Content content) {
        for(ContentModifier modifier:this.modifiers){
            modifier.setInnerContent(content);
            content = modifier;
        }
        return content;
    }

}
