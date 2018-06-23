/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.playgrounds;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class StringPlaygrounds {

    static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println(Arrays.toString("a;b;c;d".split("(?<=;)")));
//        System.out.println(Arrays.toString("a;b;c;d".split("(?=;)")));
//        System.out.println(Arrays.toString("a;b;c;d".split("((?<=;)|(?=;))")));
        String[] aEach = ("This should be formatted correctly.\n"
                + "\tline One.\n"
                + "\tline two.\n"
                + "and description after two lines").split(String.format(WITH_DELIMITER, "\\n"));
        for(String ech:aEach){
            System.out.print(ech);
        }
        System.out.println();
    }

}
