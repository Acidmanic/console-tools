/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering;

import com.acidmanic.consoletools.drawing.Scale;
import com.acidmanic.consoletools.drawing.Size;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class SizeMatchStrategySolution {

    public static final SizeMatchStrategySolution DEFAULT
            = new SizeMatchStrategySolution(new Size(0, 0), new Scale(1f, 1f));

    private Size translate;
    private Scale scale;

    public SizeMatchStrategySolution(Size translate, Scale scale) {
        this.translate = translate;
        this.scale = scale;
    }

    public SizeMatchStrategySolution() {
    }

    public Size getTranslate() {
        return translate;
    }

    public void setTranslate(Size translate) {
        this.translate = translate;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }
    
    public float resolveHorizontal(int value){
        return (((float) value)*scale.getHorizontal())+translate.getColumns();
    }
    
    public float resolveVertical(int value){
        return (((float) value)*scale.getVertical())+translate.getLines();
    }

}
