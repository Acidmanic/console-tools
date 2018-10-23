/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table.builders;

import com.acidmanic.consoletools.drawing.AsciiBorder;
import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.rendering.Box;
import com.acidmanic.consoletools.table.Cell;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * @param <T> is the Type of driven class, to be used as return value for
 * builder fluent methods
 */
public class BoxBuilderBase< T extends BoxBuilderBase> {

    protected final Box box;

    public BoxBuilderBase(Box box) {
        this.box = box;
    }

    public T padding(Padding padding) {
        this.box.setPadding(padding);
        return (T) this;
    }

    public T padding(int padding) {
        this.padding(new Padding(padding));
        return (T) this;
    }

    public T padding(int horizontal, int vertical) {
        this.box.setPadding(new Padding(horizontal, vertical));
        return (T) this;
    }

    public T margin(Padding margins) {
        this.box.setMargins(margins);
        return (T) this;
    }

    public T margin(int margins) {
        this.box.setMargins(new Padding(margins));
        return (T) this;
    }

    public T margin(int horizontal, int vertical) {
        this.box.setMargins(new Padding(horizontal, vertical));
        return (T) this;
    }

    public T border(AsciiBorder border) {
        this.box.setBorder(border);
        return (T) this;
    }

    public T outline(AsciiBorder outline) {
        this.box.setOutline(outline);
        return (T) this;
    }

    protected Box build() {
        return box;
    }

}
