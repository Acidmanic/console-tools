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
import java.util.function.Consumer;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class RowBuilder {

    private final Row row = new Row();

    public RowBuilder() {
    }

    public RowBuilder cell(Box cell) {
        this.row.getCells().add(cell);
        return this;
    }
    
    private Row getRow(){
        return this.row;
    }

    private Box getCell() {
        if (getRow().getCells().isEmpty()) {
            getRow().getCells().add(new Cell());
        }
        return getRow().getCells().get(getRow().getCells().size() - 1);
    }
    
    public RowBuilder cell(Consumer<CellBuilder> build) {
        CellBuilder builder = new CellBuilder();
        build.accept(builder);
        this.row.getCells().add(builder.build());
        return this;
    }
    
    public RowBuilder cell() {
        getRow().getCells().add(new Cell());
        return this;
    }

    public RowBuilder cell(String text) {
        getRow().getCells().add(new Cell(text));
        return this;
    }
    
    public RowBuilder cell(Renderable content) {
        return this.cell(new Box(content));
    }
    
    public RowBuilder cell(TableBuilderConsumer build) {
        TableBuilder builder = new TableBuilder();
        build.accept(builder);
        getRow().getCells().add(builder.build());
        return this;
    }
    
    
    public RowBuilder padding(Padding padding) {
        getCell().setPadding(padding);
        return this;
    }

    public RowBuilder padding(int padding) {
        getCell().setPadding(new Padding(padding));
        return this;
    }

    public RowBuilder padding(int horizontal, int vertical) {
        getCell().setPadding(new Padding(horizontal, vertical));
        return this;
    }

    public RowBuilder margins(Padding padding) {
        getCell().setMargins(padding);
        return this;
    }

    public RowBuilder margins(int padding) {
        getCell().setMargins(new Padding(padding));
        return this;
    }

    public RowBuilder margins(int horizontal, int vertical) {
        getCell().setMargins(new Padding(horizontal, vertical));
        return this;
    }

    public RowBuilder border(AsciiBorder border) {
        getCell().setBorder(border);
        return this;
    }

    public RowBuilder border() {
        return this.border(AsciiBorders.SOLID);
    }

    public RowBuilder outline(AsciiBorder outline) {
        getCell().setOutline(outline);
        return this;
    }

    public RowBuilder outline() {
        return this.outline(AsciiBorders.SOLID);
    }

    public RowBuilder text(String text) {
        if (getCell() instanceof Cell) {
            ((Cell) getCell()).setText(text);
        }
        return this;
    }

    public RowBuilder maximumWidth(int maxWidth) {
        if (getCell() instanceof Cell) {
            ((Cell) getCell()).setMaximumWidth(maxWidth);
        }
        return this;
    }
    
    public Row build() {
        return this.row;
    }
}
