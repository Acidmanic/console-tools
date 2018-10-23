/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.drawing;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public final class AsciiBorders {

    public static final AsciiBorder NONE = new AsciiBorder(" ", " ", " ", " ", " ", " ",
            " ", " ", " ", " ", " ", " ", " ");
    public static final AsciiBorder SOLID = new AsciiBorder("─", "│", "─", "│",
            "┌", "┐", "└", "┘", "├", "┤", "┬", "┴", "┼");
    
    public static final AsciiBorder BOLD = new AsciiBorder("━", "┃", "━", "┃",
            "┏", "┓", "┗", "┛", "┣", "┫", "┳", "┻", "╋");
    
    public static final AsciiBorder DOUBLELINE = new AsciiBorder("═", "║", "═", "║",
            "╔", "╗", "╚", "╝", "╠", "╣", "╦", "╩", "╬");
    
}
