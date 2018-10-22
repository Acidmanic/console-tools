/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.AsciiBorder;
import com.acidmanic.consoletools.rendering.Box;
import com.acidmanic.consoletools.rendering.BufferedStringRenderingContext;
import java.util.ArrayList;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Table extends Box {

   

    private final TableRenderable wrappedTable;

    public Table() {
        super(new TableRenderable());
        this.wrappedTable = (TableRenderable) super.getContent();
    }

    public ArrayList<Row> getRows() {
        return this.wrappedTable.getRows();
    }

    public void setCellsPadding(Padding padding) {
        this.wrappedTable.setCellsPadding(padding);
    }

    public void scanAllCells(CellScanner scanner) {
        this.wrappedTable.scanAllCells(scanner);
    }

    public void setCellsBorders(AsciiBorder border) {
        this.wrappedTable.setCellsBorders(border);
    }

    public String render() {
        BufferedStringRenderingContext context = new BufferedStringRenderingContext(this.measure());
        context.clear();
        this.render(context);
        return context.represent();
    }
}
