/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing.ascii;

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
            String topJointed, String bottomJointed,String fullJointed) {
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
