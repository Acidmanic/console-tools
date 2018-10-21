/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering.decorators;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.rendering.Renderable;
import com.acidmanic.consoletools.rendering.RenderingContext;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Padded implements Renderable {

    private final Renderable wrapped;

    private Padding padding;

    public Padded(Renderable wrapped, Padding padding) {
        this.wrapped = wrapped;
        this.padding = padding;
    }

    public Padded(Renderable wrapped) {
        this.wrapped = wrapped;
        this.padding = new Padding(0);
    }

    public Padding getPadding() {
        return padding;
    }

    public void setPadding(Padding padding) {
        this.padding = padding;
    }

    @Override
    public void render(RenderingContext context) {
        context.resetBoth();
        context.moveHorozontally(this.padding.getLeft());
        context.moveVertically(this.padding.getTop());
        context.openObject(this.wrapped.measure());
        this.wrapped.render(context);
        context.closeObject();
        context.moveHorozontally(this.padding.getLeft());
        context.moveVertically(this.padding.getBottom());
    }

    @Override
    public Size measure() {
        return this.wrapped.measure()
                .add(new Size(this.padding.getLeft() + this.padding.getRight(),
                        this.padding.getTop() + this.padding.getBottom()));
    }

}
