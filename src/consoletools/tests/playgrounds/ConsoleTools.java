/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoletools.tests.playgrounds;

import com.acidmanic.consoletools.drawing.HorizontalAlignment;
import com.acidmanic.consoletools.table.Cell;
import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.ascii.AsciiBorder;
import com.acidmanic.consoletools.drawing.ascii.AsciiBorders;
import com.acidmanic.consoletools.rendering.decorators.Bordered;
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
        row1.getCells().add(new Bordered(new Cell("Mani\nis a nice boy\nyes he is")));
        row1.getCells().add(new Cell("  Mona  "));
        row1.getCells().add(new Cell("  Mina  "));
        row1.getCells().add(new Cell("  Papa  "));

        Row row2 = new Row();
        row2.getCells().add(new Cell(" Mani "));
        Cell monaCell = new Cell(" Mona\n  Sometime goes on my nerves ");
        monaCell.setMaximumWidth(10);
        row2.getCells().add(monaCell);
        row2.getCells().add(new Bordered(new Cell("  Mina  "), AsciiBorders.DOUBLELINE));
        row2.getCells().add(new Cell("  Papa  "));

        Row row3 = new Row();
        row3.getCells().add(new Cell(" Mani "));
        row3.getCells().add(new Bordered(new Cell(" Mona ")));
        row3.getCells().add(new Bordered(new Cell(" Mina\nis the best mum ")));
        row3.getCells().add(new Cell("  Papa  "));

        Row row4 = new Row();
        row4.getCells().add(new Cell(" Mani "));
        row4.getCells().add(new Bordered(new Cell(" Mona ")));
        row4.getCells().add(new Bordered(new Cell(" Mina ")));
        row4.getCells().add(new Bordered(new Cell("  Papa \n is the best dad")));

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
        row5.getCells().add(new Bordered(new Cell("Laya"), AsciiBorders.DOUBLELINE));
        row5.getCells().add(new Bordered(tabCell, AsciiBorders.BOLD));

        Cell yaldaCell = new Cell("Yalda");
        row5.getCells().add(new Bordered(yaldaCell, AsciiBorders.DOUBLELINE));

        table.getRows().add(row1);
        table.getRows().add(row2);
        table.getRows().add(row3);
        table.getRows().add(row4);
        table.getRows().add(row5);
        table.getRows().add(row1);

        tabCell.setCellsPadding(new Padding(1, 0, 4, 1));
        yaldaCell.setPadding(new Padding(4));
        System.out.println(table.render());

    }

}
