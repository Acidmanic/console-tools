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
package com.acidmanic.consoletools.table;

import com.acidmanic.consoletools.rendering.Box;
import com.acidmanic.consoletools.rendering.StringRenderable;
import com.acidmanic.consoletools.textualcontent.builtin.TextWrapperStringModifier;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Cell extends Box {

    private StringRenderable content;

    private int maximumWidth;

    public Cell() {
        this("");
    }

    public Cell(String content) {
        super(new StringRenderable(content));
        this.content = (StringRenderable) super.getContent();
        this.maximumWidth = -1;
    }

    public int getMaximumWidth() {
        return maximumWidth;
    }

    public void setMaximumWidth(int maximumWidth) {
        this.maximumWidth = maximumWidth;
        if (maximumWidth > 0) {
            this.content.getModifierManager().setModifier(new TextWrapperStringModifier(this.maximumWidth));
        } else {
            this.content.getModifierManager().removeModifier(TextWrapperStringModifier.class);
        }
    }

    public void setText(String text) {
        this.content.setContent(text);
    }

    public String getText() {
        return this.content.getContent();
    }

}
