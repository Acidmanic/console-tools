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
package com.acidmanic.consoletools.drawing;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class AsciiBorder {

    private String top;
    private String left;
    private String buttom;
    private String right;
    private String topleftCorner;
    private String topRightCorner;
    private String bottomLeftCorner;
    private String bottomRightCorner;
    private String leftJointed;
    private String rightJointed;
    private String topJointed;
    private String bottomJointed;
    private String fullJointed;

    public AsciiBorder(String top, String left, String buttom, String right,
            String topleftCorner, String topRightCorner, String bottomLeftCorner,
            String bottomRightCorner, String leftJointed, String rightJointed,
            String topJointed, String bottomJointed, String fullJointed) {
        this.top = top;
        this.left = left;
        this.buttom = buttom;
        this.right = right;
        this.topleftCorner = topleftCorner;
        this.topRightCorner = topRightCorner;
        this.bottomLeftCorner = bottomLeftCorner;
        this.bottomRightCorner = bottomRightCorner;
        this.leftJointed = leftJointed;
        this.rightJointed = rightJointed;
        this.topJointed = topJointed;
        this.bottomJointed = bottomJointed;
        this.fullJointed = fullJointed;
    }

    public AsciiBorder() {
    }

    public AsciiBorder(AsciiBorder value) {
        this.top = value.top;
        this.left = value.left;
        this.buttom = value.buttom;
        this.right = value.right;
        this.topleftCorner = value.topleftCorner;
        this.topRightCorner = value.topRightCorner;
        this.bottomLeftCorner = value.bottomLeftCorner;
        this.bottomRightCorner = value.bottomRightCorner;
        this.leftJointed = value.leftJointed;
        this.rightJointed = value.rightJointed;
        this.topJointed = value.topJointed;
        this.bottomJointed = value.bottomJointed;
        this.fullJointed = value.fullJointed;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getButtom() {
        return buttom;
    }

    public void setButtom(String buttom) {
        this.buttom = buttom;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getTopleftCorner() {
        return topleftCorner;
    }

    public void setTopleftCorner(String topleftCorner) {
        this.topleftCorner = topleftCorner;
    }

    public String getTopRightCorner() {
        return topRightCorner;
    }

    public void setTopRightCorner(String topRightCorner) {
        this.topRightCorner = topRightCorner;
    }

    public String getBottomLeftCorner() {
        return bottomLeftCorner;
    }

    public void setBottomLeftCorner(String bottomLeftCorner) {
        this.bottomLeftCorner = bottomLeftCorner;
    }

    public String getBottomRightCorner() {
        return bottomRightCorner;
    }

    public void setBottomRightCorner(String bottomRightCorner) {
        this.bottomRightCorner = bottomRightCorner;
    }

    public String getLeftJointed() {
        return leftJointed;
    }

    public void setLeftJointed(String leftJointed) {
        this.leftJointed = leftJointed;
    }

    public String getRightJointed() {
        return rightJointed;
    }

    public void setRightJointed(String rightJointed) {
        this.rightJointed = rightJointed;
    }

    public String getTopJointed() {
        return topJointed;
    }

    public void setTopJointed(String topJointed) {
        this.topJointed = topJointed;
    }

    public String getBottomJointed() {
        return bottomJointed;
    }

    public void setBottomJointed(String bottomJointed) {
        this.bottomJointed = bottomJointed;
    }

    public String getFullJointed() {
        return fullJointed;
    }

    public void setFullJointed(String fullJointed) {
        this.fullJointed = fullJointed;
    }

}
