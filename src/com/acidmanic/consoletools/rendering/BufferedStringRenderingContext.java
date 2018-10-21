/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering;

import com.acidmanic.consoletools.drawing.Position;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.ascii.Measurer;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class BufferedStringRenderingContext extends RenderingContextBase<String, String> {

    private final char[][] buffer;

    /**
     *
     * @param size
     */
    public BufferedStringRenderingContext(Size size) {
        super(size);
        buffer = new char[size.getLines()][size.getColumns()];

        clear();
    }

    @Override
    public String represent() {
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < buffer.length; l++) {
            for (int c = 0; c < buffer[l].length; c++) {
                sb.append(this.buffer[l][c]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public final void clear() {
        super.clear();
        for (int i = 0; i < buffer.length; i++) {
            for (int j = 0; j < buffer[i].length; j++) {
                buffer[i][j] = ' ';
            }
        }
    }

    private Position resolve(int lineNumber, int columnNumber, SizeMatchStrategySolution solution) {
        int l = (int) (((float) lineNumber) * solution.getScale().getVertical());
        int c = (int) (((float) columnNumber) * solution.getScale().getHorizontal());
        l += solution.getTranslate().getLines();
        c += solution.getTranslate().getColumns();

        return new Position(c, l);
    }

    @Override
    public void put(String content, SizeMatchStrategy putStrategy) {
        Size size = new Measurer().getSize(content);
        SizeMatchStrategySolution solution = putStrategy.solve(size, this.currentClip.getSize());
        String[] lines = content.split("\\n");
        for (int l = 0; l < lines.length; l++) {
            int lineNumber = l + currentPosition.getLines();
            lineNumber = (int) solution.resolveVertical(lineNumber);
            if (currentClip.containsLine(lineNumber)) {
                for (int c = 0; c < lines[l].length(); c++) {
                    int columnNumber = c + currentPosition.getColumns();
                    columnNumber = (int) solution.resolveHorizontal(columnNumber);
                    if (currentClip.containsColumn(columnNumber)) {
                        if (validPosition(columnNumber, lineNumber)) {
                            this.buffer[lineNumber][columnNumber]
                                    = lines[l].charAt(c);
                        }
                    }
                }
            }
        }
    }

    private boolean validPosition(int columnNumber, int lineNumber) {
        return columnNumber >= 0
                && columnNumber < this.size.getColumns()
                && lineNumber >= 0
                && lineNumber < this.size.getLines();
    }

}
