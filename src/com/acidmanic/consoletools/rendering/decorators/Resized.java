/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering.decorators;

import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.rendering.Renderable;
import com.acidmanic.consoletools.rendering.RenderingContext;
import com.acidmanic.consoletools.rendering.SizeAutomation;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Resized implements Renderable {

    private final Renderable wrapped;
    private final SizeAutomation automation;

    public Resized(Renderable wrapped) {
        this.wrapped = wrapped;
        this.automation = new SizeAutomation();
    }

    @Override
    public void render(RenderingContext context) {
        this.wrapped.render(context);
    }

    @Override
    public Size measure() {
        return this.automation.measure(wrapped);
    }

    public int getWidth() {
        return automation.getColumns();
    }

    public void setWidth(int value) {
        this.automation.setColumns(value);
    }

    public int getHeight() {
        return automation.getLines();
    }

    public void setHeight(int value) {
        this.automation.setLines(value);
    }

}
