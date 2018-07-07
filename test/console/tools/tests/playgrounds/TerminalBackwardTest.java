/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console.tools.tests.playgrounds;

import com.acidmanic.consoletools.terminal.Terminal;
import com.acidmanic.consoletools.terminal.TerminalCommandBuilder;
import com.acidmanic.consoletools.terminal.TerminalStyle;
import com.acidmanic.consoletools.terminal.TerminalStyles;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TerminalBackwardTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("TTTTTTTTTTTTTTTTIIIIIIIIIIIISSSSSSSSSSISSSS");
        System.out.println("TTTTTTTTTTTTTTTTIIIIIIIIIIIISSSSSSSSSSISSSS");
        System.out.println("TTTTTTTTTTTTTTTTIIIIIIIIIIIISSSSSSSSSSISSSS");
        System.out.println("TTTTTTTTTTTTTTTTIIIIIIIIIIIISSSSSSSSSSISSSS");
        System.out.println("TTTTTTTTTTTTTTTTIIIIIIIIIIIISSSSSSSSSSISSSS");
        
        Terminal terminal = new Terminal();
        System.out.println(new TerminalCommandBuilder().moveCursorUp(2));
        terminal.setScreenAttributes(TerminalStyles.Matrix);
        System.out.println("DIIEEE");
        terminal.setScreenAttributes(TerminalStyles.Warning);
        System.out.println("This is a warning.");
        terminal.resetScreenAttributes();
    }
    
}
