/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.consoletools.textualcontent.builtin;

import com.acidmanic.consoletools.drawing.Padding;
import com.acidmanic.consoletools.drawing.ascii.StringPadder;
import com.acidmanic.consoletools.textualcontent.Content;
import com.acidmanic.consoletools.textualcontent.ContentModifier;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class PadderContentModifier extends ContentModifier {

    private final Padding padding;

    public PadderContentModifier(Padding padding, Content innerContent) {
        super(innerContent);
        this.padding = padding;
    }

    @Override
    public String getContent() {
        return new StringPadder()
                .pad(this.getInnerContent().getContent(), this.padding);
    }

}
