/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.rendering.Renderable;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.rendering.BufferedStringRenderingContext;
import com.acidmanic.consoletools.drawing.Clip;
import com.acidmanic.consoletools.drawing.ascii.Paddable;
import com.acidmanic.consoletools.drawing.Position;
import java.util.ArrayList;
import java.util.List;
import com.acidmanic.consoletools.rendering.RenderingContext;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Table implements Renderable {

    private final ArrayList<Row> rows;

    public Table() {
        this.rows = new ArrayList<>();
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public String render() {
        BufferedStringRenderingContext context
                = new BufferedStringRenderingContext(this.measure());
        context.clear();
        this.render(context);
        return context.represent();
    }

    @Override
    public void render(RenderingContext context) {
        this.render(context, this.getRows());
    }

    private void render(RenderingContext context, List<Row> renderRows) {
        TableSizeManager manager
                = new TableSizeManager(renderRows);
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

    private void renderCell(RenderingContext context, Renderable cell, Size cellSize) {
        context.openObject(cellSize);
        cell.render(context);
        context.closeObject();
    }

    @Override
    public Size measure() {
        TableSizeManager manager
                = new TableSizeManager(this.getRows());
        return manager.getTotalSize();
    }

    public void setCellsPadding(Padding padding) {
        scanAllCells(cell -> {
            if (cell instanceof Paddable) {
                ((Paddable) cell).setPadding(padding);
            }
        });
    }

    public void scanAllCells(CellScanner scanner) {
        this.rows.forEach(row -> row.getCells()
                .forEach(cell -> scanner.scan(cell)));
    }

}
