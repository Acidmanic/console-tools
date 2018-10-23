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

import com.acidmanic.consoletools.drawing.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TableSizeManager {

    private final HashMap<Integer, List<Integer>> columnWidthsByNumberOfColumns;
    private final HashMap<Integer, List<Row>> rowGroups;
    private final HashMap<Row, List<Size>> cellSizesByRow;
    private final HashMap<Integer, Integer> rowGroupWidths;
    private final HashMap<Row, Integer> rowHeights;
    private int tableWidth = 0;
    private int tableHeight = 0;
    private final List<Row> rows;
    private ColumnWidthDistributer columnWidthDistributer;

    public TableSizeManager(List<Row> rows) {
        this.columnWidthsByNumberOfColumns = new HashMap<>();
        this.rowGroups = new HashMap<>();
        this.cellSizesByRow = new HashMap<>();
        this.rowGroupWidths = new HashMap<>();
        this.rowHeights = new HashMap<>();
        this.columnWidthDistributer = new DivideEquallyColumnWidthDistributer();
        this.rows = rows;

        initColumnGroups();
        groupRows();

        measurCells();
        measureColumnWidths();
        measureRowGroupWidths();
        this.tableWidth = measureTableWidth();
        syncColumnGroupsWidths();
        measureRowHeights();
        this.tableHeight = measureTableHeight();
    }

    public Size getTotalSize() {
        return new Size(this.tableWidth, this.tableHeight);
    }

    public int getRowHeight(Row row) {
        if (this.rowHeights.containsKey(row)) {
            return this.rowHeights.get(row);
        }
        return 0;
    }

    public int getCellWidth(Row row, int cellIndex) {
        if (this.cellSizesByRow.containsKey(row)) {
            List<Size> rsizes = this.cellSizesByRow.get(row);
            if (cellIndex >= 0 && cellIndex < rsizes.size()) {
                return rsizes.get(cellIndex).getColumns();
            }
        }
        return 0;
    }

    public int getColumnWidthForCell(Row row, int cellIndex) {
        Integer columns = row.getCells().size();
        List<Integer> widths = this.columnWidthsByNumberOfColumns.get(columns);
        if (cellIndex >= 0 && cellIndex < columns) {
            return widths.get(cellIndex);
        }
        return 0;
    }

    private void initColumnGroups() {
        for (Row row : this.rows) {
            Integer columns = row.getCells().size();
            if (!this.columnWidthsByNumberOfColumns.containsKey(columns)) {
                ArrayList<Integer> widths = new ArrayList<>();
                for (int i = 0; i < columns; i++) {
                    widths.add(0);
                }
                this.columnWidthsByNumberOfColumns.put(columns, widths);
            }
        }
    }

    private void groupRows() {
        for (Row row : this.rows) {
            Integer columns = row.getCells().size();
            if (!this.rowGroups.containsKey(columns)) {
                this.rowGroups.put(columns, new ArrayList<>());
            }
            List<Row> currentRowGroup = this.rowGroups.get(columns);
            currentRowGroup.add(row);
        }
    }

    private void measureColumnWidths() {
        for (Integer columns : columnWidthsByNumberOfColumns.keySet()) {
            measureColumnGroupWidth(columns);
        }
    }

    private void measureColumnGroupWidth(Integer columns) {
        List<Integer> widths = this.columnWidthsByNumberOfColumns.get(columns);
        List<Row> groupRows = this.rowGroups.get(columns);
        for (int c = 0; c < columns; c++) {
            int width = 0;
            for (Row row : groupRows) {
                int currentWidth = cellSizesByRow.get(row).get(c).getColumns();
                if (currentWidth > width) {
                    width = currentWidth;
                }
                widths.set(c, width);
            }

        }
    }

    private void measurCells() {
        for (Row row : this.rows) {
            this.cellSizesByRow.put(row, measureRow(row));
        }
    }

    private List<Size> measureRow(Row row) {
        ArrayList<Size> ret = new ArrayList<>();
        for (int i = 0; i < row.getCells().size(); i++) {
            ret.add(row.getCells().get(i).measure());
        }
        return ret;
    }

    private int measureTableWidth() {
        int width = 0;
        for (Integer columns : columnWidthsByNumberOfColumns.keySet()) {
            int currentWidth = this.rowGroupWidths.get(columns);
            if (currentWidth > width) {
                width = currentWidth;
            }
        }
        return width;
    }

    private int getGroupWidth(List<Integer> widths) {
        int width = 0;
        for (int w : widths) {
            width += w;
        }
        return width;
    }

    private void syncColumnGroupsWidths() {
        for (Integer columns : columnWidthsByNumberOfColumns.keySet()) {
            List<Integer> widths = columnWidthsByNumberOfColumns.get(columns);
            int currentWidth = this.rowGroupWidths.get(columns);
            int delta = this.tableWidth - currentWidth;
            this.columnWidthDistributer.
                    distributeDeltaOnWidths(widths, delta);
        }
    }

    private int measureTableHeight() {
        int height = 0;
        for (Row row : this.rows) {
            height += this.rowHeights.get(row);
        }
        return height;
    }

    private int measureRowHeight(List<Size> rowSizes) {
        int height = 0;
        for (Size s : rowSizes) {
            if (s.getLines() > height) {
                height = s.getLines();
            }
        }
        return height;
    }

    private void measureRowGroupWidths() {
        for (Integer columns : columnWidthsByNumberOfColumns.keySet()) {
            int currentWidth = getGroupWidth(columnWidthsByNumberOfColumns.get(columns));
            this.rowGroupWidths.put(columns, currentWidth);
        }
    }

    private void measureRowHeights() {
        for (Row row : rows) {
            List<Size> rowSizes = cellSizesByRow.get(row);
            int height = measureRowHeight(rowSizes);
            this.rowHeights.put(row, height);
        }
    }

    public ColumnWidthDistributer getColumnWidthDistributer() {
        return columnWidthDistributer;
    }

    public void setColumnWidthDistributer(ColumnWidthDistributer columnWidthDistributer) {
        this.columnWidthDistributer = columnWidthDistributer;
    }

    public Size getMeasuredSizeForCell(Row row, int cellIndex) {
        Integer columns = row.getCells().size();
        int width = 0;
        if (this.columnWidthsByNumberOfColumns.containsKey(columns)) {
            List<Integer> widths = this.columnWidthsByNumberOfColumns.get(columns);
            if (cellIndex >= 0 && cellIndex < columns) {
                width = widths.get(cellIndex);
            }
        }
        int height = 0;
        if(this.rowHeights.containsKey(row)){
            height = this.rowHeights.get(row);
        }
        return new Size(width, height);

    }

}
