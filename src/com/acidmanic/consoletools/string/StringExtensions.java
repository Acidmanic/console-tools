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
package com.acidmanic.consoletools.string;

import java.util.ArrayList;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class StringExtensions {

    private static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

    public static String[] splitPreserving(String main, String delimiterRegEx) {
        return main.split(String.format(WITH_DELIMITER, delimiterRegEx));

    }

    public static String getStarterWhiteSpace(String value) {
        StringBuilder sb = new StringBuilder();
        for (char ch : value.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                sb.append(ch);
            } else {
                return sb.toString();
            }
        }
        return "";
    }

    public static String[] split(String main, String delimiter) {
        return split(main, delimiter, false);
    }

    public static String[] split(String main, String delimiter, boolean includeDelimiters) {
        ArrayList<String> list = new ArrayList<>();
        StringDelimiterStateMachine machine = new StringDelimiterStateMachine();
        if (includeDelimiters) {
            machine.onSegment((segment) -> {
                list.add(segment);
                list.add(delimiter);
            });
        } else {
            machine.onSegment((segment) -> {
                list.add(segment);
            });
        }
        char[] mainChars = main.toCharArray();
        machine.open(delimiter);
        for (char c : mainChars) {
            machine.pass(c);
        }
        machine.close();
        return list.toArray(new String[]{});
    }
}
