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

import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.rendering.componentfeatures.Renderable;
import com.acidmanic.consoletools.rendering.RenderingContext;
import com.acidmanic.consoletools.rendering.sizing.SizeAutomation;

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
