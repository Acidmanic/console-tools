/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering;

import com.acidmanic.consoletools.rendering.sizing.SizeMatchStrategy;
import com.acidmanic.consoletools.drawing.Clip;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.drawing.Position;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * 
 * 
 * 
 * @param <Tin> this type will be the type of input data toward the context
 * @param <Tout> this will be the type of representing data
 * 
 */
public interface RenderingContext<Tin,Tout> {

    void moveHorozontally(int columns);

    void moveVertically(int lines);

    void openObject(Size objectSize);
    
    void closeObject();
    
    void put(Tin content,SizeMatchStrategy putStrategy);
    
    void put(Tin content);

    Tout represent();

    void clear();

    void resetHorizontally();
    
    void resetVertically();
    
    void resetBoth();
    
    Position getCurrentPosition();

    Clip getCurrentClip();
}
