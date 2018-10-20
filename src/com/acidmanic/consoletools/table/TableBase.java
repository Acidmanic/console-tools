/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.ascii.Paddable;
import com.acidmanic.consoletools.rendering.Renderable;
import com.acidmanic.consoletools.rendering.RenderingContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * @param <TContext>
 */
public abstract class TableBase<TContext> implements ITable<TContext> {

    protected final ArrayList<Row> rows;

    protected abstract RenderingContext createContext();

    public TableBase() {
        this.rows = new ArrayList<>();
    }

    @Override
    public TContext render() {
        RenderingContext context = createContext();
        context.clear();
        this.render(context);
        return (TContext) context.represent();
    }

    @Override
    public ArrayList<Row> getRows() {
        return rows;
    }

    @Override
    public void render(RenderingContext context) {
        this.render(context, this.getRows());
    }

    protected void render(RenderingContext context, List<Row> renderRows) {
        TableSizeManager manager = new TableSizeManager(renderRows);
        for (Row row : renderRows) {
            Integer columns = row.getCells().size();
            int rowHeight = manager.getRowHeight(row);
            for (int i = 0; i < columns; i++) {
                Renderable cell = row.getCells().get(i);
                renderCell(context, cell, manager.getMeasuredSizeForCell(row, i));
                context.moveHorozontally(manager.getColumnWidthForCell(row, i));
            }
            context.resetHorizontally();
            context.moveVertically(rowHeight);
        }
    }

    protected void renderCell(RenderingContext context, Renderable cell, Size cellSize) {
        context.openObject(cellSize);
        cell.render(context);
        context.closeObject();
    }

    @Override
    public Size measure() {
        TableSizeManager manager = new TableSizeManager(this.getRows());
        return manager.getTotalSize();
    }

    
    @Override
    public void setCellsPadding(Padding padding) {
        scanAllCells((Renderable cell) -> {
            if (cell instanceof Paddable) {
                ((Paddable) cell).setPadding(padding);
            }
        });
    }
    
    @Override
    public void scanAllCells(CellScanner scanner) {
        this.rows.forEach((Row row) -> row.getCells().forEach((Renderable cell) -> scanner.scan(cell)));
    }

}
