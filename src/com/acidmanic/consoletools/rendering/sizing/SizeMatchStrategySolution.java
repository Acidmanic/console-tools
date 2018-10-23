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
package com.acidmanic.consoletools.rendering.sizing;

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
