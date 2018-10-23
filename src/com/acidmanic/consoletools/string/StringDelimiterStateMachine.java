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

import java.util.function.Consumer;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
class StringDelimiterStateMachine {

    private StringDelimiterState state = StringDelimiterState.normal();
    private char[] delimiter;
    private String segment = "";
    private String inmatch = "";
    private Consumer<String> segmentListener = null;

    public void onSegment(Consumer<String> listener) {
        this.segmentListener = listener;
    }

    private void callOnSegment(String segment) {
        if (this.segmentListener != null) {
            this.segmentListener.accept(segment);
        }
    }

    private void deliverSegment() {
        callOnSegment(this.segment);
        this.segment = "";
        this.inmatch = "";
    }

    private void checkForSegmentation() {
        if (this.state.type == StringDelimiterState.TYPE_INMATCH) {
            if (this.state.matchIndex >= delimiter.length) {
                deliverSegment();
                this.state = StringDelimiterState.normal();
            }
        }
    }

    public void open(String delimiter) {
        this.state = StringDelimiterState.normal();
        this.delimiter = delimiter.toCharArray();
        this.inmatch = "";
        this.segment = "";
    }

    public void pass(char c) {
        if (this.state.type == StringDelimiterState.TYPE_NORMAL) {
            if (c == delimiter[0]) {
                this.state = StringDelimiterState.inmatch(1);
                this.inmatch += c;
                this.checkForSegmentation();
            } else {
                this.segment += c;
            }
        } else if (this.state.type == StringDelimiterState.TYPE_INMATCH) {
            if (c == delimiter[this.state.matchIndex]) {
                this.state.matchIndex += 1;
                this.inmatch += c;
                this.checkForSegmentation();
            } else {
                this.state = StringDelimiterState.normal();
                this.segment += this.inmatch;
                this.inmatch = "";
            }
        }
    }

    public void close() {
        if (this.state.type == StringDelimiterState.TYPE_NORMAL) {
            deliverSegment();
        } else if (this.state.type == StringDelimiterState.TYPE_INMATCH) {
            if (this.state.matchIndex == this.delimiter.length) {
                /**
                 * Odd! if state is InMatch and all delimiter characters are
                 * passed, then it should have been delivered in pass method
                 * already.
                 */
            } else {
                this.segment += this.inmatch;
                this.inmatch = "";
                deliverSegment();
            }
        }
    }

}
