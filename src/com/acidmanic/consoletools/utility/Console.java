/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.utility;

import com.acidmanic.consoletools.rendering.BufferedStringRenderingContext;
import com.acidmanic.consoletools.rendering.componentfeatures.Renderable;
import java.io.PrintStream;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Console {

    private final PrintStream out;

    public Console() {
        this.out = System.out;
    }

    public Console(PrintStream out) {
        this.out = out;
    }

    public void println(Renderable renderable) {
        BufferedStringRenderingContext context = new BufferedStringRenderingContext(renderable.measure());
        context.clear();
        renderable.render(context);
        println(context.represent());
    }

    public void println(String string) {
        this.out.println(string);
    }
}
