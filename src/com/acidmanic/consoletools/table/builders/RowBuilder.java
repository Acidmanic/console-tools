/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table.builders;

import com.acidmanic.consoletools.rendering.Box;
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

    public RowBuilder cell(Consumer<CellBuilder> build) {
        CellBuilder builder = new CellBuilder();
        build.accept(builder);
        this.row.getCells().add(builder.build());
        return this;
    }
    
    public Row build() {
        return this.row;
    }
}
