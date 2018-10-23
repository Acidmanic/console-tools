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
package com.acidmanic.consoletools.rendering;

import com.acidmanic.consoletools.rendering.sizing.SizeMatchStrategySolution;
import com.acidmanic.consoletools.rendering.sizing.SizeMatchStrategy;
import com.acidmanic.consoletools.drawing.Position;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.string.StringMeasurer;

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
        Size size = new StringMeasurer().getSize(content);
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
