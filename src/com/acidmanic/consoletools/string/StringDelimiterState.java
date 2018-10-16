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
class StringDelimiterState {
        public int matchIndex;
        public int type;
        
        public static final int TYPE_NORMAL =0;
        public static final int TYPE_INMATCH =1;
        public static final int TYPE_FINISHED =2;
        
        
        public StringDelimiterState(){
            this.type=TYPE_NORMAL;
            this.matchIndex =0;
        }
        
        public static StringDelimiterState normal(){
            return new StringDelimiterState();
        }
        
        public static StringDelimiterState finished(){
            StringDelimiterState ret = new StringDelimiterState();
            ret.matchIndex=-1;
            ret.type = TYPE_FINISHED;
            return ret;
        }
        
        public static StringDelimiterState inmatch(int index){
            StringDelimiterState ret = new StringDelimiterState();
            ret.matchIndex=index;
            ret.type = TYPE_INMATCH;
            return ret;
        }
        
        
}
