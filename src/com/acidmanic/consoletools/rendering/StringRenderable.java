/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering;

import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.string.StringMeasurer;
import com.acidmanic.consoletools.textualcontent.StringModifierManager;
import com.acidmanic.consoletools.textualcontent.builtin.BuiltinStringModifierPriority;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class StringRenderable implements Renderable {

    private final StringModifierManager modifierManager;

    private String content;

    public StringRenderable(String content) {
        this.content = content;
        this.modifierManager = new StringModifierManager(new BuiltinStringModifierPriority());
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void render(RenderingContext context) {
        String preprocessed = this.modifierManager.applyAll(this.content);
        context.put(preprocessed);
    }

    @Override
    public Size measure() {
        String preprocessed = this.modifierManager.applyAll(this.content);
        return new StringMeasurer().getSize(preprocessed);
    }

    public StringModifierManager getModifierManager() {
        return this.modifierManager;
    }

}
