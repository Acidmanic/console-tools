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

import java.util.List;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class DivideEquallyColumnWidthDistributer implements ColumnWidthDistributer {

    @Override
    public void distributeDeltaOnWidths(List<Integer> widths, int delta) {
        int index = 0;
        while (delta > 0) {
            widths.set(index, widths.get(index) + 1);
            index += 1;
            if (index >= widths.size()) {
                index = 0;
            }
            delta -= 1;
        }
    }

}
