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
import com.acidmanic.consoletools.drawing.AsciiBorder;
import com.acidmanic.consoletools.drawing.AsciiBorders;
import com.acidmanic.consoletools.rendering.BorderRenderer;
import com.acidmanic.consoletools.rendering.componentfeatures.Renderable;
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
