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
import com.acidmanic.consoletools.rendering.Renderable;
import com.acidmanic.consoletools.rendering.RenderingContext;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Bordered  implements Renderable{

    private AsciiBorder asciiBorder;
    private final Renderable owner;

    public Bordered(Renderable owner,AsciiBorder asciiBorder) {
        this.asciiBorder = asciiBorder;
        this.owner = owner;
    }
    
    

    public Bordered(Renderable owner) {
        this.owner = owner;
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
        Size size = owner.measure();
        return size.add(new Size(2, 2));
    }

    @Override
    public void render(RenderingContext context) {
        new BorderRenderer().renderBorderOnContext(context, this.asciiBorder);
        context.resetBoth();
        context.moveHorozontally(1);
        context.moveVertically(1);
        context.openObject(owner.measure());
        owner.render(context);
        context.closeObject();
    }

}
