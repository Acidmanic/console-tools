/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.textualcontent;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public interface ContentModifierPriority {
    boolean compare(ContentModifier wraps,ContentModifier isBeeingWrapped);
}
