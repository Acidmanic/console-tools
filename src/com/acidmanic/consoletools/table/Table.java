/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.Renderable;
import com.acidmanic.consoletools.Size;
import com.acidmanic.consoletools.BufferedStringRenderingContext;
import com.acidmanic.consoletools.Clip;
import com.acidmanic.consoletools.Paddable;
import com.acidmanic.consoletools.Position;
import com.acidmanic.consoletools.StringRenderingContext;
import java.util.ArrayList;
import java.util.List;

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
        context.reset();
        this.render(context);
        return context.renrerAll();
    }

    @Override
    public void render(StringRenderingContext context) {
        this.render(context, this.getRows());
    }

    private void render(StringRenderingContext context, List<Row> renderRows) {
        TableSizeManager manager
                = new TableSizeManager(renderRows);
        for (Row row : renderRows) {
            Integer columns = row.getCells().size();
            int rowHeight = manager.getRowHeight(row);
            for (int i = 0; i < columns; i++) {
                Renderable cell = row.getCells().get(i);
                renderRenderableOnContext(context, cell, manager.getMeasuredSizeForCell(row,i));
                context.moveHorozontally(manager.getColumnWidthForCell(row, i));
            }
            context.resetHorizontally();
            context.moveVertically(rowHeight);
        }
    }

    private void renderRenderableOnContext(StringRenderingContext context,
            Renderable renderable,
            Size measuredSize) {
        Position currentPosition = context.getCurrentPosition();
        context.pushClip(new Clip(currentPosition,measuredSize));
        renderable.render(context);
        context.resetHorizontally();
        context.resetVertically();
        context.popClip();
    }

    @Override
    public Size measure() {
        TableSizeManager manager
                = new TableSizeManager(this.getRows());
        return manager.getTotalSize();
    }
    
    
    
    public void setCellsPadding(Padding padding){
        scanAllCells(cell -> {
            if(cell instanceof Paddable){
                ((Paddable)cell).setPadding(padding);
            }
        });
    }
    
    public void scanAllCells(CellScanner scanner){
        this.rows.forEach(row -> row.getCells()
                .forEach(cell -> scanner.scan(cell)));
    }

}
