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
