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
package com.acidmanic.consoletools.rendering;

import com.acidmanic.consoletools.drawing.AsciiBorder;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class BorderRenderer {

    public void renderBorderOnContext(RenderingContext context,
            AsciiBorder asciiBorder) {
        context.put(asciiBorder.getTopleftCorner());
        context.moveHorozontally(1);
        for (int i = 1; i < context.getCurrentClip().getColumns() - 1; i++) {
            context.put(asciiBorder.getTop());
            context.moveHorozontally(1);
        }
        context.put(asciiBorder.getTopRightCorner());
        context.resetHorizontally();
        context.moveVertically(1);
        for (int i = 1; i < context.getCurrentClip().getLines() - 1; i++) {
            context.resetHorizontally();
            context.put(asciiBorder.getLeft());
            int horMove = context.getCurrentClip().getColumns() - 1;
            context.moveHorozontally(horMove);
            context.put(asciiBorder.getRight());
            context.moveVertically(1);
        }
        context.resetHorizontally();
        context.put(asciiBorder.getBottomLeftCorner());
        context.moveHorozontally(1);
        for (int i = 1; i < context.getCurrentClip().getColumns() - 1; i++) {
            context.put(asciiBorder.getButtom());
            context.moveHorozontally(1);
        }
        context.put(asciiBorder.getBottomRightCorner());
        context.resetBoth();
    }
}
