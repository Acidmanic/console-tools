/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering;

import com.acidmanic.consoletools.drawing.ascii.AsciiBorder;

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
