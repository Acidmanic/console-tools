/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table.builders;

import com.acidmanic.consoletools.drawing.AsciiBorder;
import com.acidmanic.consoletools.drawing.AsciiBorders;
import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.rendering.Box;
import com.acidmanic.consoletools.rendering.componentfeatures.Renderable;
import com.acidmanic.consoletools.table.Cell;
import com.acidmanic.consoletools.table.Row;
import com.acidmanic.consoletools.table.Table;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TableBuilder {

    protected final Table table;

    public TableBuilder() {
        this.table = new Table();
    }

    private Row getRow() {
        if (this.table.getRows().isEmpty()) {
            this.table.getRows().add(new Row());
        }
        return this.table.getRows().get(this.table.getRows().size() - 1);
    }

    private Box getCell() {
        if (getRow().getCells().isEmpty()) {
            getRow().getCells().add(new Cell());
        }
        return getRow().getCells().get(getRow().getCells().size() - 1);
    }

    /* pre-population */
    public TableBuilder table(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            this.table.getRows().add(new Row());
            for (int j = 0; j < columns; j++) {
                getRow().getCells().add(new Cell());
            }
        }
        return this;
    }

    public TableBuilder table(String[][] contents) {
        for (String[] row : contents) {
            this.table.getRows().add(new Row());
            for (String cell : row) {
                getRow().getCells().add(new Cell(cell));
            }
        }
        return this;
    }

    public TableBuilder table(Box[][] cells) {
        for (Box[] row : cells) {
            this.table.getRows().add(new Row());
            getRow().getCells().addAll(Arrays.asList(row));
        }
        return this;
    }

    public TableBuilder table(Renderable[][] contents) {
        for (Renderable[] rowContent : contents) {
            this.table.getRows().add(new Row());
            for (Renderable cellContent : rowContent) {
                getRow().getCells().add(new Box(cellContent));
            }
        }
        return this;
    }

    public TableBuilder table(List contents) {
        if (!contents.isEmpty()) {
            Object instances = contents.get(0);
            if (instances instanceof String[]) {
                return tableString(contents);
            }
            if (instances instanceof Box[]) {
                return tableBox(contents);
            }
            if (instances instanceof Renderable[]) {
                return tableRenderable(contents);
            }
        }
        return this;
    }

    private TableBuilder tableString(List<String[]> contents) {
        for (String[] row : contents) {
            this.table.getRows().add(new Row());
            for (String cell : row) {
                getRow().getCells().add(new Cell(cell));
            }
        }
        return this;
    }

    private TableBuilder tableBox(List<Box[]> contents) {
        for (Box[] row : contents) {
            this.table.getRows().add(new Row());
            getRow().getCells().addAll(Arrays.asList(row));
        }
        return this;
    }

    private TableBuilder tableRenderable(List<Renderable[]> contents) {
        for (Renderable[] row : contents) {
            this.table.getRows().add(new Row());
            for (Renderable cell : row) {
                getRow().getCells().add(new Box(cell));
            }
        }
        return this;
    }

    /* table itself */
    public TableBuilder tableBorder(AsciiBorder border) {
        this.table.setBorder(border);
        return this;
    }

    public TableBuilder tableBorder() {
        return tableBorder(AsciiBorders.SOLID);
    }

    public TableBuilder tableOutline(AsciiBorder outline) {
        this.table.setOutline(outline);
        return this;
    }

    public TableBuilder tableOutline() {
        return tableOutline(AsciiBorders.SOLID);
    }

    public TableBuilder tablePadding(Padding padding) {
        this.table.setPadding(padding);
        return this;
    }

    public TableBuilder tablePadding(int padding) {
        this.table.setPadding(new Padding(padding));
        return this;
    }

    public TableBuilder tablePadding(int horizontal, int vertical) {
        this.table.setPadding(new Padding(horizontal, vertical));
        return this;
    }

    public TableBuilder tableMargins(Padding margins) {
        this.table.setMargins(margins);
        return this;
    }

    public TableBuilder tableMargins(int margins) {
        this.table.setMargins(new Padding(margins));
        return this;
    }

    public TableBuilder tableMargins(int horizontal, int vertical) {
        this.table.setMargins(new Padding(horizontal, vertical));
        return this;
    }

    /*  Rows    */
    public TableBuilder row() {
        this.table.getRows().add(new Row());
        return this;
    }

    public TableBuilder row(Row row) {
        this.table.getRows().add(row);
        return this;
    }

    public TableBuilder row(Consumer<RowBuilder> build) {
        RowBuilder rb = new RowBuilder();
        build.accept(rb);
        this.table.getRows().add(rb.build());
        return this;
    }

    /* cells */
    public TableBuilder cell() {
        getRow().getCells().add(new Cell());
        return this;
    }

    public TableBuilder cell(String text) {
        getRow().getCells().add(new Cell(text));
        return this;
    }

    public TableBuilder cell(Box cell) {
        getRow().getCells().add(cell);
        return this;
    }

    public TableBuilder cell(Renderable content) {
        return this.cell(new Box(content));
    }

    public TableBuilder cell(Consumer<CellBuilder> build) {
        CellBuilder builder = new CellBuilder();
        build.accept(builder);
        getRow().getCells().add(builder.build());
        return this;
    }

    public TableBuilder cell(TableBuilderConsumer build) {
        TableBuilder builder = new TableBuilder();
        build.accept(builder);
        getRow().getCells().add(builder.build());
        return this;
    }

    public TableBuilder padding(Padding padding) {
        getCell().setPadding(padding);
        return this;
    }

    public TableBuilder padding(int padding) {
        getCell().setPadding(new Padding(padding));
        return this;
    }

    public TableBuilder padding(int horizontal, int vertical) {
        getCell().setPadding(new Padding(horizontal, vertical));
        return this;
    }

    public TableBuilder margins(Padding padding) {
        getCell().setMargins(padding);
        return this;
    }

    public TableBuilder margins(int padding) {
        getCell().setMargins(new Padding(padding));
        return this;
    }

    public TableBuilder margins(int horizontal, int vertical) {
        getCell().setMargins(new Padding(horizontal, vertical));
        return this;
    }

    public TableBuilder border(AsciiBorder border) {
        getCell().setBorder(border);
        return this;
    }

    public TableBuilder border() {
        return this.border(AsciiBorders.SOLID);
    }

    public TableBuilder outline(AsciiBorder outline) {
        getCell().setOutline(outline);
        return this;
    }

    public TableBuilder outline() {
        return this.outline(AsciiBorders.SOLID);
    }

    public TableBuilder text(String text) {
        if (getCell() instanceof Cell) {
            ((Cell) getCell()).setText(text);
        }
        return this;
    }

    public TableBuilder maximumWidth(int maxWidth) {
        if (getCell() instanceof Cell) {
            ((Cell) getCell()).setMaximumWidth(maxWidth);
        }
        return this;
    }

    /* all cells at once */
    public TableBuilder borderAll(AsciiBorder border) {
        this.table.scanAllCells((Box cell) -> cell.setBorder(border));
        return this;
    }

    public TableBuilder borderAll() {
        this.table.scanAllCells((Box cell) -> cell.setBorder(AsciiBorders.SOLID));
        return this;
    }

    public TableBuilder outlineAll(AsciiBorder outline) {
        this.table.scanAllCells((Box cell) -> cell.setOutline(outline));
        return this;
    }

    public TableBuilder outlineAll() {
        this.table.scanAllCells((Box cell) -> cell.setOutline(AsciiBorders.SOLID));
        return this;
    }

    public TableBuilder padAll(Padding padding) {
        this.table.scanAllCells((Box cell) -> cell.setPadding(padding));
        return this;
    }

    public TableBuilder padAll(int padding) {
        this.table.scanAllCells((Box cell) -> cell.setPadding(new Padding(padding)));
        return this;
    }

    public TableBuilder padAll(int horizontal, int vertical) {
        this.table.scanAllCells((Box cell) -> cell.setPadding(new Padding(horizontal, vertical)));
        return this;
    }

    public TableBuilder marginAll(Padding margins) {
        this.table.scanAllCells((Box cell) -> cell.setMargins(margins));
        return this;
    }

    public TableBuilder marginAll(int margins) {
        this.table.scanAllCells((Box cell) -> cell.setMargins(new Padding(margins)));
        return this;
    }

    public TableBuilder marginAll(int horizontal, int vertical) {
        this.table.scanAllCells((Box cell) -> cell.setMargins(new Padding(horizontal, vertical)));
        return this;
    }

    public TableBuilder textAll(String text) {
        this.table.scanAllCells((Box cell) -> {
            if (cell instanceof Cell) {
                ((Cell) cell).setText(text);
            }
        });
        return this;
    }

    /* Builds */
    public Table build() {
        return this.table;
    }

}
