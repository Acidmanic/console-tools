/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.ascii.AsciiBorder;
import com.acidmanic.consoletools.drawing.ascii.AsciiBorders;
import com.acidmanic.consoletools.rendering.BorderRenderer;
import com.acidmanic.consoletools.rendering.RenderingContext;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class BorderedCell extends Cell {

    private AsciiBorder asciiBorder;

    public BorderedCell() {
        this.asciiBorder = AsciiBorders.SOLID;
    }

    public BorderedCell(String content) {
        super(content);
        this.asciiBorder = AsciiBorders.SOLID;
    }

    public AsciiBorder getAsciiBorder() {
        return asciiBorder;
    }

    public void setAsciiBorder(AsciiBorder asciiBorder) {
        this.asciiBorder = asciiBorder;
    }

    @Override
    public Size measure() {
        Size size = super.measure();
        return size.add(new Size(2, 2));
    }

    @Override
    public void render(RenderingContext context) {
        new BorderRenderer().renderBorderOnContext(context, this.asciiBorder);
        context.resetBoth();
        context.moveHorozontally(1);
        context.moveVertically(1);
        context.openObject(super.measure());
        super.render(context);
        context.closeObject();
    }

}
