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
package com.acidmanic.consoletools.string;

import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.Padding;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class StringMeasurer {

    public StringMeasurer() {
    }

    public Size getSize(String content) {
        String[] lines = StringExtensions.split(content, "\n");

        int maxWidth = 0;
        for (String line : lines) {
            if (line.length() > maxWidth) {
                maxWidth = line.length();
            }
        }
        return new Size(maxWidth, lines.length);
    }

    public Size getSize(String content, Padding padding) {
        Size size = getSize(content);
        size.setColumns(size.getColumns() + padding.getLeft() + padding.getRight());
        size.setLines(size.getLines() + padding.getTop() + padding.getBottom());
        return size;
    }

}
