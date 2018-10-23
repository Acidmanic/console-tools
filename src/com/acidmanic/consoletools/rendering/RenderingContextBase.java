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
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.Clip;
import com.acidmanic.consoletools.drawing.Position;
import java.util.Stack;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * @param <Tin> this type will be the type of input data toward the context
 * @param <Tout> this will be the type of representing data
 */
public abstract class RenderingContextBase<Tin, Tout> implements RenderingContext<Tin, Tout> {

    private final Stack<Clip> clipStack;
    protected Clip currentClip;

    protected Size size;

    protected Position currentPosition;

    public RenderingContextBase(Size size) {
        this.clipStack = new Stack<>();
        this.clearPositionAndSizes(size);
    }

    @Override
    public void openObject(Size size) {
        this.clipStack.push(this.currentClip);
        this.currentClip = new Clip(this.getCurrentPosition(), size);
    }

    @Override
    public void closeObject() {
        resetBoth();
        this.currentClip = this.clipStack.pop();
    }

    @Override
    public void resetHorizontally() {
        this.currentPosition.setColumns(this.currentClip.getStartColumn());
    }

    @Override
    public void resetVertically() {
        this.currentPosition.setLines(this.currentClip.getStartLine());
    }

    @Override
    public void resetBoth() {
        resetVertically();
        resetHorizontally();
    }

    @Override
    public void clear() {
        this.clearPositionAndSizes(this.size);
    }

    protected final void clearPositionAndSizes(Size size) {
        this.clipStack.clear();
        this.size = size;
        this.currentPosition = new Position(0, 0);
        this.currentClip = new Clip(this.currentPosition, size);
    }

    @Override
    public void moveHorozontally(int columns) {
        int newCol = columns + this.getCurrentPosition().getColumns();
        if (this.currentClip.containsColumn(newCol)) {
            this.currentPosition.setColumns(newCol);
        }
    }

    @Override
    public void moveVertically(int lines) {
        int newLine = lines + this.getCurrentPosition().getLines();
        if (this.currentClip.containsLine(newLine)) {
            this.currentPosition.setLines(newLine);
        }
    }

    @Override
    public Position getCurrentPosition() {
        return this.currentPosition;
    }

    @Override
    public Clip getCurrentClip() {
        return this.currentClip;
    }

    @Override
    public void put(Tin content) {
        put(content, (Size actual, Size expected) -> SizeMatchStrategySolution.DEFAULT);
    }

}
