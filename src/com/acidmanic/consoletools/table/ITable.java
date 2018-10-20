/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.rendering.Renderable;
import java.util.ArrayList;

/**
 *
 * This interface determines what methods should a table provide.
 * 
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * @param <TContext> the output type of RenderingContext. 
 */
public interface ITable<TContext> extends Renderable {

    ArrayList<Row> getRows();

    TContext render();

    void setCellsPadding(Padding padding);
    
    void scanAllCells(CellScanner scanner);
}
