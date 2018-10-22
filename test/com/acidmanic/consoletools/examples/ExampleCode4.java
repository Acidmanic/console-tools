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
 * This example shows how to set width for a cell and how it results in
 * text-breaking behavior
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class ExampleCode4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Table table = new Table();

        table.setBorder(AsciiBorders.BOLD);

        Row row = new Row();

        table.getRows().add(row);

        Cell wrapCell = new Cell("This is a long text that hopefully will not "
                + "fit inside the cell in one line!");

        wrapCell.setMaximumWidth(20);
        wrapCell.setBorder(AsciiBorders.SOLID);
        row.getCells().add(wrapCell);

        line("Add cell that breaks long text");

        System.out.println(table.render());
    }

    private static void line(String message) {
        System.out.println("---------------------------------");
        System.out.println(message + "\n");

    }

}
