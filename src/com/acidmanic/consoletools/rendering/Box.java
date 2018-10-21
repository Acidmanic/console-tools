/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering;

import com.acidmanic.consoletools.drawing.Clip;
import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.ascii.AsciiBorder;
import com.acidmanic.consoletools.drawing.ascii.Paddable;
import com.acidmanic.consoletools.rendering.decorators.Bordered;
import com.acidmanic.consoletools.rendering.decorators.Padded;
import com.acidmanic.consoletools.rendering.decorators.Resized;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Box implements Renderable, Paddable {

    private class Rect {

        public int top;
        public int right;
        public int left;
        public int bottom;

        public int horizontal;
        public int vertical;

        public Rect() {
            this.top = 0;
            this.left = 0;
            this.right = 0;
            this.bottom = 0;
            this.horizontal = 0;
            this.vertical = 0;
        }

    }

    /* properties */
    private AsciiBorder border;
    private AsciiBorder outline;

    private Padding padding;
    private Padding margins;

    /* status */
    private Renderable content;
    private Resized resized;
    private Renderable padded;
    private Renderable bordered;
    private Renderable margined;
    private Renderable outlined;
    private Rect additionalEdges;

    public Box(Renderable content) {
        this.content = content;
        this.resized = null;
        this.border = null;
        this.outline = null;
        this.padding = new Padding(0);
        this.margins = new Padding(0);
        this.additionalEdges = new Rect();
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
        this.resized = new Resized(this.content);
        this.padded = new Padded(this.resized, this.padding);
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
        this.additionalEdges = getAddingEdgeSizes();
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

    private Rect getAddingEdgeSizes() {
        Rect ret = new Rect();
        ret.top = this.padding.getTop() + this.margins.getTop();
        ret.left = this.padding.getLeft() + this.margins.getLeft();
        ret.bottom = this.padding.getBottom() + this.margins.getBottom();
        ret.right = this.padding.getRight() + this.margins.getRight();
        if (this.border != null) {
            ret.top += 1;
            ret.left += 1;
            ret.right += 1;
            ret.bottom += 1;
        }
        if (this.outline != null) {
            ret.top += 1;
            ret.left += 1;
            ret.right += 1;
            ret.bottom += 1;
        }
        ret.horizontal = ret.left + ret.right;
        ret.vertical = ret.top + ret.bottom;
        return ret;

    }

    public void setHeight(int value) {
        this.resized.setHeight(value - this.additionalEdges.vertical);
    }

    public void setWidth(int value) {
        this.resized.setWidth(value-this.additionalEdges.horizontal);
    }

    public int getHeight() {
        return this.resized.getHeight()+this.additionalEdges.vertical;
    }

    public int getWidth() {
        return this.resized.getWidth()+this.additionalEdges.horizontal;
    }
}
