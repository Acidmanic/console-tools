/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.rendering.Box;
import com.acidmanic.consoletools.rendering.StringRenderable;
import com.acidmanic.consoletools.textualcontent.builtin.TextWrapperStringModifier;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Cell extends Box {

    private StringRenderable content;

    private int maximumWidth;

    public Cell() {
        this("");
    }

    public Cell(String content) {
        super(new StringRenderable(content));
        this.content = (StringRenderable) super.getContent();
        this.maximumWidth = -1;
    }

    public int getMaximumWidth() {
        return maximumWidth;
    }

    public void setMaximumWidth(int maximumWidth) {
        this.maximumWidth = maximumWidth;
        if (maximumWidth > 0) {
            this.content.getModifierManager().setModifier(new TextWrapperStringModifier(this.maximumWidth));
        } else {
            this.content.getModifierManager().removeModifier(TextWrapperStringModifier.class);
        }
    }

}
