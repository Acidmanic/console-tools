/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering.modifiers;

import com.acidmanic.consoletools.rendering.Renderable;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public abstract class RenderableModifier implements Renderable{
    
    protected Renderable innerRenderable;

    public RenderableModifier(Renderable wrappedObject) {
        this.innerRenderable = wrappedObject;
    }

    public Renderable getInnerRenderable() {
        return innerRenderable;
    }

    public void setInnerRenderable(Renderable innerRenderable) {
        this.innerRenderable = innerRenderable;
    }
    
    
    
    
}
