/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.string;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class StringExtensions {
    
    
    private static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    
    public static String[] splitPreserving(String main,String delimiterRegEx){
        return main.split(String.format(WITH_DELIMITER, delimiterRegEx));
        
    }
    
    public static String getStarterWhiteSpace(String value){
        StringBuilder sb = new StringBuilder();
        for(char ch:value.toCharArray()){
            if(Character.isWhitespace(ch)){
                sb.append(ch);
            }else{
                return sb.toString();
            }
        }
        return "";
    }
}
