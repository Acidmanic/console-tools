/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoletools.tests.playgrounds;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.ascii.AsciiBorder;
import com.acidmanic.consoletools.drawing.ascii.AsciiBorders;
import com.acidmanic.consoletools.rendering.Renderable;
import com.acidmanic.consoletools.table.Bordered;
import com.acidmanic.consoletools.table.Cell;
import com.acidmanic.consoletools.table.Row;
import com.acidmanic.consoletools.table.Table;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class PaddingButtomPlayground {

    public static void main(String[] args) {
        Table table = new Table();

        Row row1 = new Row();
        Row row2 = new Row();

        Cell cell1 = new Cell("CELL\nCONTENT");
        Cell cell2 = new Cell("CELL\nCONTENT");

        row1.getCells().add(new Bordered(cell1,AsciiBorders.SOLID));
        row2.getCells().add(new Bordered(cell2,AsciiBorders.SOLID));

        cell1.setPadding(new Padding(4, 0));
        cell2.setPadding(new Padding(4, 4, 4, 4));

        table.getRows().add(row1);
        table.getRows().add(row2);

        System.out.println(table.render());

    }
}
