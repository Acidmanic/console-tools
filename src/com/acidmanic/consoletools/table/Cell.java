/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.ascii.StringPadder;
import com.acidmanic.consoletools.drawing.ascii.Measurer;
import com.acidmanic.consoletools.drawing.ascii.Paddable;
import com.acidmanic.consoletools.rendering.Renderable;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.rendering.RenderingContext;
import com.acidmanic.consoletools.textualcontent.ContentModifier;
import com.acidmanic.consoletools.textualcontent.ContentModifierManager;
import com.acidmanic.consoletools.textualcontent.PadderContentModifier;
import com.acidmanic.consoletools.textualcontent.RawStringContent;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Cell implements Renderable,Paddable{

    private String content;
    private ContentModifierManager modifierManager;
    
    
    private Padding padding;
    
    public Cell() {
        this("");
    }

    public Cell(String content) {
        this.content = content;
        this.padding = new Padding(0);
        this.modifierManager = new ContentModifierManager();
    }
    
    
    @Override
    public Size measure() {
        return new Measurer().getSize(content,padding);
    }

    @Override
    public void render(RenderingContext context) {
        
        context.put(this.exposeContent());
    }

    private String exposeContent() {
        return modifierManager
                .applyAll(new RawStringContent(content)).getContent();
    }

    @Override
    public Padding getPadding() {
        return padding;
    }

    
    @Override
    public void setPadding(Padding padding) {
        this.padding = padding;
        modifierManager.setModifier(new PadderContentModifier(padding, null));
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
