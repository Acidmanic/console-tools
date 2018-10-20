What does this library have?
============================

* A set of classes to managedly control terminal styles and colors.
* A set of classes that provide some table rendering functionality.
* Very simple text input components. like StyledTextInputBox.


How to use it
=============

Print Styled text.
----------------------

To print styled text, you can use the class: **Terminal**. It can move the cursor, set the foreground and background colors separatedly. Another way for styling printed text, is to call *Terminal.setScreenAttributes()* method with a **TerminalStyle** object. 
This class contains more styling preferences. An object of type **TerminalStyle**, can be constructed and configured manually using it's accessors. you can also use one of the built-in Styles avalable in **TerminalStyles** class. 

By default, **Terminal** will control *System.out* stream, but you can change this by passing your subjected stream to its constructor.

Print Tables
------------

Printing tables is easy!  **Table** is a class that wraps a list of **Row**s, and a **Row** is basically a list of renderables. any renderable can be added to a Row as a cell. there is also a **Cell** class that you can use for creating cells. For a **Cell**, you can set padding and maximum width.

A **Table** itself, is also a renderable, which means you can use them as cells for an outer table.

Print with a border around
--------------------------

Another useful class is **Bordered** class. this class is a renderable wrapping another renderable and can be used instead of the original one. this way the new renderable will be drawn with a border. A **Bordered** object can get an object of type **AsciiBorder** via its constructor or through *Bordered.setAsciiBorder(.)* method. The **AsciiBorder** object will define the style of border. The hard way for creating an **AsciiBorder** object is to instanciate one, and pass needed characters for each edge and corner, through its constructor or accessor methods. If you just need a normal border around your renderable, you can easily use one of the built-in borders available in **AsciiBorders**.

Since a tables and cells are **Renderable**s, they can be printed with a border just by wrapping them inside a **Bordered** object and using the **Bordered** object instead.



TextInput
=========

In the package *com.acidmanic.consoletools.drawing.interaction*, the classes **TextInput**, **InputTextBox** and **StyledTextInput** are defined. these classes are diven from **Input<String>**. **Input<T>** is an abstract class which its goal is to receive information nedded to constrcut an object of Type T.

**TextInput** object, simply prints a message (label) and reads the result string.

**InputTextBox** object will draw a box on the console placing the label and users answer in it.

**StyledTextInput** object is almost the same as **InputTextBox** except that it uses Styling functionalities to style the box.


Example Codes
=============

Styled Printing
---------------

```java

        Terminal terminal = new Terminal();

        /* Print Black Text on Red background */
        
        terminal.setScreenAttributes(Terminal.Constants.FOREGROUND_BLACK,
                Terminal.Constants.BACKGROUND_RED);
        
        System.out.println("Black Text On Red Background");

        /* Print Styled Text using Style class */
        
        TerminalStyle style = new TerminalStyle(Terminal.Constants.FOREGROUND_WHITE, 
                Terminal.Constants.BACKGROUND_BLUE, 
                Terminal.Constants.BRIGHTNESS_DIM);
        
        terminal.setScreenAttributes(style);
        
        System.out.println("A dim white text printed on blue background");
        
        /* Using built-in styles */
        
        terminal.setScreenAttributes(TerminalStyles.Matrix);
        
        System.out.println("Matrix like text, using built-in styles");
        
        
        /* Print On Other Stream (In this case: System.err) */
        
        terminal = new Terminal(System.err);
        
        terminal.setScreenAttributes(TerminalStyles.Matrix);
        
        System.err.println("Matrix like text, using built-in styles");


```






Printing Tables
---------------


```java

        /* create a table */
        Table table = new Table();

        /* create first row, and add to table */
        Row firstRow = new Row();

        table.getRows().add(firstRow);

        /* create two cells for first row */
        Cell firstRowLeft = new Cell("Left-Cell");

        Cell firstRowRight = new Cell("Right-Cell");

        firstRow.getCells().add(firstRowLeft);

        firstRow.getCells().add(firstRowRight);

        /* That's it! we can print the table now */
        System.out.println(table.render());

        /* Set a padding for all cells in table */
        table.setCellsPadding(new Padding(2, 0));

        line("Table With Padding");// print a line and a message between tables

        System.out.println(table.render());

        /* Make cells for second row bordered */
        Row secondRow = new Row();

        secondRow.getCells().add(new Bordered(firstRowLeft));

        secondRow.getCells().add(new Bordered(firstRowRight));

        table.getRows().add(secondRow);

        line("Bordered Cells");

        System.out.println(table.render());

        /* border up the table! */
        table.setBorder(AsciiBorders.DOUBLELINE);

        line("Bordered Table");

        System.out.println(table.render());

        /* Adding a table as a cell */
        Table innerTable = new Table();
        innerTable.getRows().add(new Row());
        innerTable.getRows().add(new Row());
        innerTable.getRows().get(0).getCells().add(new Bordered(new Cell("Inner00")));
        innerTable.getRows().get(0).getCells().add(new Bordered(new Cell("Inner01")));
        innerTable.getRows().get(1).getCells().add(new Bordered(new Cell("Inner10")));
        innerTable.getRows().get(1).getCells().add(new Bordered(new Cell("Inner11")));

        line("A Simple Table to be used as one cell");

        System.out.println(innerTable.render());

        Row thirdRow = new Row();
        thirdRow.getCells().add(innerTable);

        table.getRows().add(thirdRow);

        line("Nested Tables");

        System.out.println(table.render());

```












