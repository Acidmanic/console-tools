/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.playgrounds;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.AsciiBorders;
import com.acidmanic.consoletools.rendering.BufferedStringRenderingContext;
import com.acidmanic.consoletools.rendering.componentfeatures.Renderable;
import com.acidmanic.consoletools.rendering.decorators.Bordered;
import com.acidmanic.consoletools.rendering.decorators.Padded;
import com.acidmanic.consoletools.rendering.decorators.Resized;
import com.acidmanic.consoletools.table.Cell;
import com.acidmanic.consoletools.terminal.Terminal;
import com.acidmanic.consoletools.terminal.styling.TerminalStyles;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class DecoratorsTest {

    public static void main(String[] args) {

        Cell c = new Cell("CELL");

        print(c, "Original");

        Renderable padded = new Padded(c, new Padding(3));

        print(padded, "Padded");

        Renderable bordered = new Bordered(padded, AsciiBorders.SOLID);

        print(bordered, "Bordered");

        Renderable margined = new Padded(bordered, new Padding(3));

        print(margined, "Magined");

        Renderable outlined = new Bordered(margined, AsciiBorders.DOUBLELINE);

        print(outlined, "Outlined");
        
        
        Resized resized = new Resized(outlined);
        
        resized.setWidth(40);
        resized.setHeight(30);
        
        print(resized,"Resized");

    }

    private static void print(Renderable renderable, String message) {
        System.out.println("-----------------------");
        System.out.println(message);
        System.out.println("-----------------------");

        Size size = renderable.measure();

        BufferedStringRenderingContext context = new BufferedStringRenderingContext(size);

        context.clear();

        renderable.render(context);

        String result = context.represent();

        new Terminal().setScreenAttributes(TerminalStyles.UglyMac);
        System.out.println(result);
        new Terminal().resetScreenAttributes();
    }

}
