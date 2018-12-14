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
package com.acidmanic.consoletools.drawing.interaction;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class PrefillableInputStream extends InputStream {

    private final String value;
    private int index = 0;

    public PrefillableInputStream(String value) {
        this.value = value;
        this.index = 0;
    }

    @Override
    public int read() throws IOException {
        if(index >= value.length()){
            return -1;
        }
        index +=1;
        return value.charAt(index-1);
    }

    @Override
    public long skip(long n) throws IOException {
        index += n;
        return index;
    }

    @Override
    public int available() throws IOException {
        return this.value.length()-index;
    }
    
    
    
    
    

}
