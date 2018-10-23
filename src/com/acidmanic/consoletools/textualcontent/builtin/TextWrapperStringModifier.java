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
package com.acidmanic.consoletools.textualcontent.builtin;

import com.acidmanic.consoletools.string.StringExtensions;
import com.acidmanic.consoletools.textualcontent.StringModifier;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TextWrapperStringModifier implements StringModifier {

    private final int maximumWidth;

    public TextWrapperStringModifier(int forcedWidth) {
        this.maximumWidth = forcedWidth;
    }

    private String devide(String part, StringBuilder sb) {
        while (part.length() > this.maximumWidth) {
            String starter = part.substring(0, this.maximumWidth);
            part = part.substring(this.maximumWidth, part.length());
            sb.append(starter).append("\n");
        }
        return part;
    }

    private String wrapIfNeeded(String line) {
        StringBuilder ret = new StringBuilder();
        String[] parts = StringExtensions.splitPreserving(line, "(\\s|\\.|;|,|-)");
        int width = 0;
        for (String part : parts) {
            if (width + part.length() > this.maximumWidth) {
                width = 0;
                ret.append("\n");
            }
            part = devide(part, ret);
            ret.append(part);
            width += part.length();
        }
        return ret.toString();
    }

    @Override
    public String process(String original) {
        String lines[] = original.split("\\n");
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (String line : lines) {
            line = wrapIfNeeded(line);
            sb.append(sep).append(line);
            sep = "\n";
        }
        return sb.toString();
    }
}
