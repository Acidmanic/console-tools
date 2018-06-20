/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console.tools;

import com.acidmanic.consoletools.table.Cell;
import com.acidmanic.consoletools.table.Padding;
import com.acidmanic.consoletools.table.Row;
import com.acidmanic.consoletools.table.Table;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class ConsoleTools {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Table table = new Table();

        Row row1 = new Row();
        row1.getCells().add(new Cell("Mani\nis a nice boy\n"));
        row1.getCells().add(new Cell("  Mona  "));
        row1.getCells().add(new Cell("  Mina  "));
        row1.getCells().add(new Cell("  Papa  "));

        Row row2 = new Row();
        row2.getCells().add(new Cell(" Mani "));
        row2.getCells().add(new Cell(" Mona\n  Sometime goes on my nerves "));
        row2.getCells().add(new Cell("  Mina  "));
        row2.getCells().add(new Cell("  Papa  "));

        Row row3 = new Row();
        row3.getCells().add(new Cell(" Mani "));
        row3.getCells().add(new Cell(" Mona "));
        row3.getCells().add(new Cell(" Mina\n is the best mum "));
        row3.getCells().add(new Cell("  Papa  "));

        Row row4 = new Row();
        row4.getCells().add(new Cell(" Mani "));
        row4.getCells().add(new Cell(" Mona "));
        row4.getCells().add(new Cell(" Mina "));
        row4.getCells().add(new Cell("  Papa \n is the best dad"));

        Table tabCell = new Table();
        Row r1 = new Row();
        r1.getCells().add(new Cell("X"));
        r1.getCells().add(new Cell("O"));
        r1.getCells().add(new Cell("X"));
        Row r2 = new Row();
        r2.getCells().add(new Cell("O"));
        r2.getCells().add(new Cell("X"));
        r2.getCells().add(new Cell("O"));
        tabCell.getRows().add(r1);
        tabCell.getRows().add(r2);
        tabCell.getRows().add(r1);

        Row row5 = new Row();
        row5.getCells().add(new Cell("Laya"));
        row5.getCells().add(tabCell);
        row5.getCells().add(new Cell("Yalda"));

        table.getRows().add(row1);
        table.getRows().add(row2);
        table.getRows().add(row3);
        table.getRows().add(row4);
        table.getRows().add(row5);
        table.getRows().add(row1);

        tabCell.setCellsPadding(new Padding(1, 0, 4, 1));

        System.out.println(table.render());

    }

}
