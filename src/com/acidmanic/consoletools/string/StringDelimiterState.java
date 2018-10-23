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
