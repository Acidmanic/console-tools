/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.examples;

import com.acidmanic.consoletools.drawing.AsciiBorders;
import com.acidmanic.consoletools.table.Cell;
import com.acidmanic.consoletools.table.Row;
import com.acidmanic.consoletools.table.Table;

/**
 *
 * This example demonstrates how to add a table as a cell to another table.
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class ExampleCode3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Table outerTable = new Table();

        outerTable.setBorder(AsciiBorders.DOUBLELINE);

        /* Adding a table as a cell */
        Table innerTable = new Table();
        innerTable.getRows().add(new Row());
        innerTable.getRows().add(new Row());
        innerTable.getRows().get(0).getCells().add(new Cell("Inner00"));
        innerTable.getRows().get(0).getCells().add(new Cell("Inner01"));
        innerTable.getRows().get(1).getCells().add(new Cell("Inner10"));
        innerTable.getRows().get(1).getCells().add(new Cell("Inner11"));

        innerTable.setCellsBorders(AsciiBorders.SOLID);
        innerTable.setBorder(AsciiBorders.SOLID);

        line("A Simple Table to be used as one cell");

        System.out.println(innerTable.render());

        Row row = new Row();

        /* Add a simple cell first */
        row.getCells().add(new Cell("A Cell At Left"));

        /* Add innerTable as another cell beside the former */
        row.getCells().add(innerTable);

        outerTable.getRows().add(row);

        line("Nested Tables");

        System.out.println(outerTable.render());
    }

    private static void line(String message) {
        System.out.println("---------------------------------");
        System.out.println(message + "\n");

    }

}
