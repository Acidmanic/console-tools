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
public interface StringRenderingContext {

    void moveHorozontally(int columns);

    void moveVertically(int lines);

    void put(String string);

    String renrerAll();

    void reset();

    void resetHorizontally();
    
    Position getCurrentPosition();
    
    void pushClip(Clip clip);
    Clip popClip();

    void resetVertically();
}
