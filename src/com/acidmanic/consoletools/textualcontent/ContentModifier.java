/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.textualcontent;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public abstract class ContentModifier implements Content{
    
    private Content innerContent;

    public ContentModifier(Content innerContent) {
        this.innerContent = innerContent;
    }

    public Content getInnerContent() {
        return innerContent;
    }

    public void setInnerContent(Content innerContent) {
        this.innerContent = innerContent;
    }
    
    
    
}
