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
package com.acidmanic.consoletools.terminal.styling;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TerminalControlEscapeSequences {

    public static final char ESCAPE = 0x1B;
   
    public static final int ATTR_RESET_ALL = 0;
    
    public static final int ATTR_UNDERSCORE = 4;
    public static final int ATTR_BLINK = 5;
    public static final int ATTR_REVERSE = 7;
    public static final int ATTR_HIDDEN = 8;
    
    
    public static final int BRIGHTNESS_BRIGHT = 1;
    public static final int BRIGHTNESS_DIM = 2;
    
    
    public static final int FOREGROUND_BLACK = 30;
    public static final int FOREGROUND_RED = 31;
    public static final int FOREGROUND_GREEN = 32;
    public static final int FOREGROUND_YELLOW = 33;
    public static final int FOREGROUND_BLUE = 34;
    public static final int FOREGROUND_MAGENTA = 35;
    public static final int FOREGROUND_CYAN = 36;
    public static final int FOREGROUND_WHITE = 37;
    
    
    public static final int BACKGROUND_BLACK = 40;
    public static final int BACKGROUND_RED = 41;
    public static final int BACKGROUND_GREEN = 42;
    public static final int BACKGROUND_YELLOW = 43;
    public static final int BACKGROUND_BLUE = 44;
    public static final int BACKGROUND_MAGENTA = 45;
    public static final int BACKGROUND_CYAN = 46;
    public static final int BACKGROUND_WHITE = 47;
    
    
    public static final String FONT_ALTERNATIVE = ")";
    public static final String FONT_MAIN = "(";
    

    
    
}
