/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.playgrounds;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.AsciiBorders;
import com.acidmanic.consoletools.rendering.Box;
import com.acidmanic.consoletools.rendering.BufferedStringRenderingContext;
import com.acidmanic.consoletools.rendering.componentfeatures.Renderable;
import com.acidmanic.consoletools.table.Cell;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class BoxTest {

    public static void main(String[] args) {

        Box b = new Box(new Cell("CONTENT"));

        print(b, "Default Box");

        b.setBorder(AsciiBorders.SOLID);

        print(b, "Add Borders");

        b.setPadding(new Padding(2));

        print(b, "Add Paddings");

        b.setMargins(new Padding(3));

        print(b, "Add Margins");

        b.setOutline(AsciiBorders.BOLD);

        print(b, "Add Outlines");

        b.setContent(b.clone());

        print(b, "Box in Box!");
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

        System.out.println(result);
    }
}
