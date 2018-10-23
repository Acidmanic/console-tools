/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.examples;

import com.acidmanic.consoletools.drawing.AsciiBorder;
import com.acidmanic.consoletools.drawing.AsciiBorders;
import com.acidmanic.consoletools.rendering.BufferedStringRenderingContext;
import com.acidmanic.consoletools.table.Table;
import com.acidmanic.consoletools.table.builders.TableBuilder;
import com.acidmanic.consoletools.utility.Console;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class ExampleCode6 {

    public static void main(String[] args) {

        Table table = new TableBuilder()
                .tableBorder(AsciiBorders.BOLD)
                .cell("OnlyCell")
                .border()
                .cell((TableBuilder builder) -> builder
                        .row().cell("00").cell("01")
                        .row().cell("10").cell("11")
                        .borderAll().tableBorder())
                .row().cell("Bottom-Left").border()
                .cell("Middle").border()
                .cell("Bottom-Right").border()
                .row().cell((TableBuilder builder) -> builder.table(3, 3)
                        .textAll("*").borderAll().padAll(3, 1).tableBorder())
                .build();

        System.out.println(table.render());

    }
}
