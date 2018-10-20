/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.examples;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.ascii.AsciiBorders;
import com.acidmanic.consoletools.rendering.Renderable;
import com.acidmanic.consoletools.rendering.decorators.Bordered;
import com.acidmanic.consoletools.table.Cell;
import com.acidmanic.consoletools.table.Row;
import com.acidmanic.consoletools.table.Table;

/**
 *
 * This example shows how to create tables
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class ExampleCode2 {

    public static void main(String[] args) {

        /* create a table */
        Table table = new Table();

        /* create first row, and add to table */
        Row firstRow = new Row();

        table.getRows().add(firstRow);

        /* create two cells for first row */
        Cell firstRowLeft = new Cell("Left-Cell");

        Cell firstRowRight = new Cell("Right-Cell");

        firstRow.getCells().add(firstRowLeft);

        firstRow.getCells().add(firstRowRight);

        /* That's it! we can print the table now */
        System.out.println(table.render());

        /* Set a padding for all cells in table */
        table.setCellsPadding(new Padding(2, 0));

        line("Table With Padding");// print a line and a message between tables

        System.out.println(table.render());

        /* Make cells for second row bordered */
        Row secondRow = new Row();

        secondRow.getCells().add(new Bordered(firstRowLeft));

        secondRow.getCells().add(new Bordered(firstRowRight));

        table.getRows().add(secondRow);

        line("Bordered Cells");

        System.out.println(table.render());

        /* border up the table! */
        table.setBorder(AsciiBorders.DOUBLELINE);

        line("Bordered Table");

        System.out.println(table.render());

        /* Adding a table as a cell */
        Table innerTable = new Table();
        innerTable.getRows().add(new Row());
        innerTable.getRows().add(new Row());
        innerTable.getRows().get(0).getCells().add(new Bordered(new Cell("Inner00")));
        innerTable.getRows().get(0).getCells().add(new Bordered(new Cell("Inner01")));
        innerTable.getRows().get(1).getCells().add(new Bordered(new Cell("Inner10")));
        innerTable.getRows().get(1).getCells().add(new Bordered(new Cell("Inner11")));

        line("A Simple Table to be used as one cell");

        System.out.println(innerTable.render());

        Row thirdRow = new Row();
        thirdRow.getCells().add(innerTable);

        table.getRows().add(thirdRow);

        line("Nested Tables");

        System.out.println(table.render());

    }

    private static void line(String message) {
        System.out.println("---------------------------------");
        System.out.println(message + "\n");

    }
}
