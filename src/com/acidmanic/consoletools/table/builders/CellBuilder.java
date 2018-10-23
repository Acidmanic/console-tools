/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table.builders;

import com.acidmanic.consoletools.table.Cell;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class CellBuilder extends BoxBuilderBase<CellBuilder> {

    private final Cell cell;

    public CellBuilder() {
        super(new Cell());
        this.cell = (Cell) super.box;
    }

    public CellBuilder text(String text) {
        this.cell.setText(text);
        return this;
    }

    @Override
    public Cell build() {
        return cell;
    }
}
