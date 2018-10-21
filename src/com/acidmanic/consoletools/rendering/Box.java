/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.ascii.AsciiBorder;
import com.acidmanic.consoletools.drawing.ascii.Paddable;
import com.acidmanic.consoletools.rendering.decorators.Bordered;
import com.acidmanic.consoletools.rendering.decorators.Padded;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Box implements Renderable, Paddable {

    /* properties */
    private AsciiBorder border;
    private AsciiBorder outline;

    private Padding padding;
    private Padding margins;

    /* status */
    private Renderable content;
    private Renderable padded;
    private Renderable bordered;
    private Renderable margined;
    private Renderable outlined;

    public Box(Renderable content) {
        this.content = content;
        this.border = null;
        this.outline = null;
        this.padding = new Padding(0);
        this.margins = new Padding(0);

        setupHirarechy();
    }

    @Override
    public void render(RenderingContext context) {
        this.outlined.render(context);
    }

    @Override
    public Size measure() {
        return this.outlined.measure();
    }

    @Override
    public Padding getPadding() {
        return this.padding;
    }

    @Override
    public void setPadding(Padding padding) {
        this.padding = padding;
        setupHirarechy();
    }

    private void setupHirarechy() {
        this.padded = new Padded(this.content, this.padding);
        if (this.border == null) {
            this.bordered = this.padded;
        } else {
            this.bordered = new Bordered(this.padded, this.border);
        }
        this.margined = new Padded(this.bordered, this.margins);
        if (this.outline == null) {
            this.outlined = this.margined;
        } else {
            this.outlined = new Bordered(this.margined, this.outline);
        }
    }

    public AsciiBorder getBorder() {
        return border;
    }

    public void setBorder(AsciiBorder border) {
        this.border = border;
        setupHirarechy();
    }

    public AsciiBorder getOutline() {
        return outline;
    }

    public void setOutline(AsciiBorder outline) {
        this.outline = outline;
        setupHirarechy();
    }

    public Padding getMargins() {
        return margins;
    }

    public void setMargins(Padding margins) {
        this.margins = margins;
        setupHirarechy();
    }

    public Renderable getContent() {
        return content;
    }

    public void setContent(Renderable content) {
        this.content = content;
        setupHirarechy();
    }

    @Override
    @SuppressWarnings({"CloneDoesntCallSuperClone", "CloneDeclaresCloneNotSupported"})
    public Box clone() {
        Box ret = new Box(this.content);
        ret.border = new AsciiBorder(this.border);
        ret.outline = new AsciiBorder(this.outline);
        ret.padding = new Padding(this.padding);
        ret.margins = new Padding(this.margins);

        ret.setupHirarechy();
        return ret;
    }

}
