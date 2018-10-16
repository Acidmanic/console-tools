/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoletools.tests.playgrounds;

import com.acidmanic.consoletools.drawing.interaction.InputTextBox;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TextBoxTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InputTextBox textBox = new InputTextBox();
        textBox.setWidth(40);
        textBox.setLabel("This is going to be a logn label, it should be longer than 40 chars, then we can see if the label cell correctly breaks.");
        textBox.askInput();
        System.out.println("the value from text box: " + textBox.getValue());
    }
    
}
