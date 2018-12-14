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
                .tableBorder(AsciiBorders.BOLD)  /* set a BOLD border for table itself */
                .cell("OnlyCell")                /* add a cell with string content, (by default first row has been added) */
                .border()                        /* set default border for the cell */
                .cell((TableBuilder builder) -> builder     /* add new cell (beside last one), building a table as cell's content */
                        .row().cell("00").cell("01")        /* create first row, then two cells for it with values 00 and 01 */
                        .row().cell("10").cell("11")        /* create second row, then two cells for it with values 10 and 11 */
                        .borderAll().tableBorder())         /* set default border for all cells, then set default border for table*/
                .row().cell("Bottom-Left").border(AsciiBorders.DOUBLELINE) /* add new row to main table, then add a text cell with DOUBLELINE borders.*/
                .cell("Middle").border(AsciiBorders.BOLD)                  /* add another text cell to the row with BOLD border */
                .cell("Bottom-Right").border(AsciiBorders.SOLID)           /* add third text cell to the row with SOLID (default) border.*/
                .row().cell((TableBuilder builder) -> builder.table(3, 3)       /* start a new row (third row) add a cell with a  3 by 3 table as it's content. */
                        .textAll("*").borderAll().padAll(3, 1).tableBorder())   /* all cells have '*' as content, default border, 3 chars H-padding and 1 char V-Padding. the table gets default border */
                .cell((TableBuilder builder)                                    /* add another cell to third row with a table as its content. */
                        -> builder.table(new String[][]{{"A", "B"}, {"C", "D"},{"E","F"}}) /* this inner table will have three rows, two cell each row corresponding to given 2d array*/
                        .padAll(3,2).tableBorder(AsciiBorders.BOLD))            /* all 6 cell of inner table will get 3 chars H-padding and 2 chars V-padding. the table itself gets a BOLD border. */
                .build();                       /* build main table*/

        System.out.println(table.render());

    }
}
