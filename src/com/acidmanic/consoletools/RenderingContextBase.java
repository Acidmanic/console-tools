/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools;

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
    public void openObject(Size objectSize) {
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

}
