/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
