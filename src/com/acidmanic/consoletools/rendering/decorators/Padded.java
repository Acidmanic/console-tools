/* 
 * Copyright (C) 2018 Mani Moayedi (acidmanic.moayedi@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.acidmanic.consoletools.rendering.decorators;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.rendering.componentfeatures.Renderable;
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
