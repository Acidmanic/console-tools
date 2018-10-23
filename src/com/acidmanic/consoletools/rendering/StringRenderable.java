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

import com.acidmanic.consoletools.rendering.componentfeatures.Renderable;
import com.acidmanic.consoletools.drawing.Size;
import com.acidmanic.consoletools.string.StringMeasurer;
import com.acidmanic.consoletools.textualcontent.StringModifierManager;
import com.acidmanic.consoletools.textualcontent.builtin.BuiltinStringModifierPriority;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class StringRenderable implements Renderable {

    private final StringModifierManager modifierManager;

    private String content;

    public StringRenderable(String content) {
        this.content = content;
        this.modifierManager = new StringModifierManager(new BuiltinStringModifierPriority());
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void render(RenderingContext context) {
        String preprocessed = this.modifierManager.applyAll(this.content);
        context.put(preprocessed);
    }

    @Override
    public Size measure() {
        String preprocessed = this.modifierManager.applyAll(this.content);
        return new StringMeasurer().getSize(preprocessed);
    }

    public StringModifierManager getModifierManager() {
        return this.modifierManager;
    }

}
