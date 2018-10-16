/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
