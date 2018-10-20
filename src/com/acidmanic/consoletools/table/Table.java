/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.ascii.AsciiBorder;
import com.acidmanic.consoletools.rendering.BufferedStringRenderingContext;
import com.acidmanic.consoletools.rendering.Renderable;
import com.acidmanic.consoletools.rendering.RenderingContext;
import com.acidmanic.consoletools.rendering.decorators.Bordered;
import java.util.ArrayList;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Table implements ITable<String> {

    private class StringTable extends TableBase<String> {

        @Override
        protected RenderingContext createContext() {
            return new BufferedStringRenderingContext(this.measure());
        }

    }

    private final ITable<String> wrappedTable;
    private Renderable borderedTable = null;

    public Table() {
        this.wrappedTable = new StringTable();
    }

    @Override
    public ArrayList<Row> getRows() {
        return this.wrappedTable.getRows();
    }

    @Override
    public String render() {
        if (this.borderedTable == null) {
            return this.wrappedTable.render();
        } else {
            BufferedStringRenderingContext context
                    = new BufferedStringRenderingContext(this.measure());
            this.borderedTable.render(context);
            return context.represent();
        }
    }

    @Override
    public void render(RenderingContext context) {
        if (this.borderedTable == null) {
            this.wrappedTable.render(context);
        } else {
            this.wrappedTable.render(context);
        }
    }

    @Override
    public Size measure() {
        if (this.borderedTable == null) {
            return this.wrappedTable.measure();
        } else {
            return this.borderedTable.measure();
        }
    }

    public void setBorder(AsciiBorder border) {
        this.borderedTable 
                = new Bordered(this.wrappedTable,border);
    }

    @Override
    public void setCellsPadding(Padding padding) {
        this.wrappedTable.setCellsPadding(padding);
    }

    @Override
    public void scanAllCells(CellScanner scanner) {
        this.wrappedTable.scanAllCells(scanner);
    }
}
