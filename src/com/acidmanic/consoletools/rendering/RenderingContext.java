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
