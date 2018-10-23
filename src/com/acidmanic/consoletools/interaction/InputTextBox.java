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
package com.acidmanic.consoletools.interaction;

import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.AsciiBorder;
import com.acidmanic.consoletools.drawing.AsciiBorders;
import com.acidmanic.consoletools.rendering.BufferedStringRenderingContext;
import com.acidmanic.consoletools.rendering.componentfeatures.Renderable;
import com.acidmanic.consoletools.rendering.RenderingContext;
import com.acidmanic.consoletools.rendering.decorators.Bordered;
import com.acidmanic.consoletools.table.Cell;
import com.acidmanic.consoletools.table.Row;
import com.acidmanic.consoletools.table.Table;
import com.acidmanic.consoletools.terminal.Terminal;
import com.acidmanic.consoletools.terminal.styling.TerminalStyle;
import com.acidmanic.consoletools.terminal.styling.TerminalStyles;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class InputTextBox extends Input<String> {

    private int width = 100;
    private TerminalStyle intputStyle = TerminalStyles.BlueInput;
    private TerminalStyle style = TerminalStyles.Matrix;
    private AsciiBorder tableBorder = AsciiBorders.BOLD;
    private AsciiBorder innerBorders = AsciiBorders.SOLID;

    public TerminalStyle getIntputStyle() {
        return intputStyle;
    }

    public void setIntputStyle(TerminalStyle intputStyle) {
        this.intputStyle = intputStyle;
    }

    public TerminalStyle getStyle() {
        return style;
    }

    public void setStyle(TerminalStyle style) {
        this.style = style;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public InputTextBox(String label, String value) {
        super(label, value);
    }

    public InputTextBox(String label) {
        super(label);
    }

    public InputTextBox() {
    }

    public AsciiBorder getTableBorder() {
        return tableBorder;
    }

    public void setTableBorder(AsciiBorder tableBorder) {
        this.tableBorder = tableBorder;
    }

    public AsciiBorder getInnerBorders() {
        return innerBorders;
    }

    public void setInnerBorders(AsciiBorder innerBorders) {
        this.innerBorders = innerBorders;
    }

    @Override
    public String askInput() {
        Table table = new Table();
        Cell labelCell = new Cell(paddLabel());
        labelCell.setMaximumWidth(this.getWidth());
        labelCell.setBorder(this.innerBorders);

        table.getRows().add(new Row());
        table.getRows().add(new Row());

        table.getRows().get(0).getCells().add(labelCell);

        Cell valueCell = new Cell("");
        valueCell.setBorder(this.innerBorders);
        table.getRows().get(1).getCells().add(valueCell);

        Renderable borderedTable = new Bordered(table, this.tableBorder);

        Terminal terminal = new Terminal();

        Size tableSize = borderedTable.measure();
        Size cursorMove = new Size(-3, 4);

        RenderingContext<String, String> context = new BufferedStringRenderingContext(tableSize);
        borderedTable.render(context);
        String tableString = context.represent();
        terminal.resetScreenAttributes();
        terminal.setScreenAttributes(this.getStyle());
        System.out.println(tableString);
        terminal.resetScreenAttributes();
        terminal.moveCursor(mirror(cursorMove));
        terminal.setScreenAttributes(this.getIntputStyle());
        this.value = readLine();
        terminal.resetScreenAttributes();
        terminal.moveCursor(cursorMove);
        return this.value;
    }

    private Size mirror(Size size) {
        return new Size(-size.getColumns(), -size.getLines());
    }

    private String paddLabel() {
        String ret = this.getLabel();
        Boolean even = false;
        while (ret.length() < this.width) {
            if (even) {
                ret = " " + ret;
            } else {
                ret = ret + " ";
            }
            even = !even;
        }
        return ret;
    }

}
