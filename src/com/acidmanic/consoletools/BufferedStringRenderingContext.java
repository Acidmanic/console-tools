/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools;

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
    public void put(String string) {
        String[] lines = string.split("\\n");
        for (int l = 0; l < lines.length; l++) {
            int lineNumber = l + currentPosition.getLines();
            if (currentClip.containsLine(lineNumber)) {
                for (int c = 0; c < lines[l].length(); c++) {
                    int columnNumber = c + currentPosition.getColumns();
                    if (currentClip.containsColumn(columnNumber)) {
                        this.buffer[lineNumber][columnNumber]
                                = lines[l].charAt(c);
                    }
                }
            }
        }
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

}
