/* 
 * Copyright (C) 2018 Mani Moayedi (acidmanic.moayedi@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.AsciiBorder;
import com.acidmanic.consoletools.rendering.Box;
import com.acidmanic.consoletools.rendering.componentfeatures.Renderable;
import com.acidmanic.consoletools.rendering.RenderingContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TableRenderable implements Renderable {

    protected final ArrayList<Row> rows;

    public TableRenderable() {
        this.rows = new ArrayList<>();
    }

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
                Box cell = row.getCells().get(i);
                renderCell(context, cell, manager.getMeasuredSizeForCell(row, i));
                context.moveHorozontally(manager.getColumnWidthForCell(row, i));
            }
            context.resetHorizontally();
            context.moveVertically(rowHeight);
        }
    }

    protected void renderCell(RenderingContext context, Box cell, Size cellSize) {
        context.openObject(cellSize);
        cell.setWidth(cellSize.getColumns());
        cell.setHeight(cellSize.getLines());
        cell.render(context);
        context.closeObject();
    }

    @Override
    public Size measure() {
        TableSizeManager manager = new TableSizeManager(this.getRows());
        return manager.getTotalSize();
    }

    public void setCellsPadding(Padding padding) {
        scanAllCells((Box cell) -> cell.setPadding(padding));
    }

    public void setCellsBorders(AsciiBorder border) {
        scanAllCells((Box cell) -> cell.setBorder(border));
    }

    public void scanAllCells(CellScanner scanner) {
        this.rows.forEach((Row row) -> row.getCells().forEach((Box cell) -> scanner.scan(cell)));
    }

}
