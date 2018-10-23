/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.playgrounds;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.AsciiBorders;
import com.acidmanic.consoletools.table.Cell;
import com.acidmanic.consoletools.table.Row;
import com.acidmanic.consoletools.table.Table;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class PaddingBottomPlayground {

    public static void main(String[] args) {
        Table table = new Table();

        Row row2 = new Row();

        Cell cell2 = new Cell("CELL\nCONTENT");

        cell2.setBorder(AsciiBorders.SOLID);

        row2.getCells().add(cell2);

        cell2.setPadding(new Padding(4, 4, 4, 4));

        table.getRows().add(row2);

        System.out.println(table.render());

    }
}
