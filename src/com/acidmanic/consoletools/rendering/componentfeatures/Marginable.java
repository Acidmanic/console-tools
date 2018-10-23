/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.rendering.componentfeatures;

import com.acidmanic.consoletools.drawing.Padding;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public interface Marginable {

    Padding getMargins();

    void setMargins(Padding margins);
}
