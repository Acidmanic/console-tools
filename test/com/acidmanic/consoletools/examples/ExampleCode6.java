/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.examples;

import com.acidmanic.consoletools.drawing.AsciiBorders;
import com.acidmanic.consoletools.table.Table;
import com.acidmanic.consoletools.table.builders.TableBuilder;

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
                .row().cell("Bottom-Left").border(AsciiBorders.DOUBLELINE)
                .cell("Middle").border(AsciiBorders.BOLD)
                .cell("Bottom-Right").border(AsciiBorders.SOLID)
                .row().cell((TableBuilder builder) -> builder.table(3, 3)
                        .textAll("*").borderAll().padAll(3, 1).tableBorder())
                .cell((TableBuilder builder)
                        -> builder.table(new String[][]{{"A", "B"}, {"C", "D"},{"E","F"}})
                        .padAll(3,2).tableBorder(AsciiBorders.BOLD))
                .build();

        System.out.println(table.render());

    }
}
