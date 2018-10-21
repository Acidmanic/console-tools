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

Printing tables is easy!  **Table** is a class that wraps a list of **Row**s, and a **Row** is basically a list of **Box**es. any **Box** can be added to a Row as a cell. there is also a **Cell** class that you can use for creating cells. For a **Cell**. **Cell** objects can have their texts modified due to different situations. currently the only feature that is covered this way, is to break (word-wrap) text when a maximum width is set for the cell. you can unset the maximum width by setting it to -1.

A **Table** itself, is also a **Box**, which means you can use them as cells for an outer table.

A **Box** is a renderable object that you can set Padding, Border, Margin, Outline, Width and Height for it. Therefore both **Table** and **Cell** objects have these properties available.

To set border for a **Box**, you will need an **AsciiBorder** object. The **AsciiBorder** object will define the style of border. The hard way for creating an **AsciiBorder** object is to instantiate one, and pass needed characters for each edge and corner, through its constructor or accessor methods. If you just need a normal border around your renderable, you can easily use one of the built-in borders available in **AsciiBorders**.


TextInput
---------

In the package *com.acidmanic.consoletools.drawing.interaction*, the classes **TextInput**, **InputTextBox** and **StyledTextInput** are defined. these classes are diven from **Input<String>**. **Input<T>** is an abstract class which its goal is to receive information nedded to constrcut an object of Type T.

**TextInput** object, simply prints a message (label) and reads the input stream for users response.

**InputTextBox** object will draw a box on the console placing the label and users answer in it.

**StyledTextInput** object is almost the same as **InputTextBox** except that it uses Styling functionalities to style the box.


Example Codes
=============

You can find this example codes in Test Packages, under com.acidmanic.consoletools.examples. except for ExampleCode5 witch is placed in Source Packages.


Styled Printing 
---------------

ExampleCode1

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






Creating Tables, Padding and border
-----------------------------------

ExampleCode2

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
        table.setCellsPadding(new Padding(2));

        line("Table With Padding");// print a line and a message

        System.out.println(table.render());

        /* Make cells for second row bordered */
        Row secondRow = new Row();

        Cell secondRowLeft = new Cell("Left-Cell");
        Cell secondRowRight = new Cell("Right-Cell");

        secondRowLeft.setBorder(AsciiBorders.SOLID);
        secondRowRight.setBorder(AsciiBorders.SOLID);

        secondRow.getCells().add(secondRowLeft);
        secondRow.getCells().add(secondRowRight);

        table.getRows().add(secondRow);

        line("Bordered Cells");

        System.out.println(table.render());

        /* border up the table! */
        table.setBorder(AsciiBorders.DOUBLELINE);

        line("Bordered Table");

        System.out.println(table.render());

```

Nested Tables
-------------

ExampleCode3

```java

        Table outerTable = new Table();

        outerTable.setBorder(AsciiBorders.DOUBLELINE);

        /* Adding a table as a cell */
        Table innerTable = new Table();
        innerTable.getRows().add(new Row());
        innerTable.getRows().add(new Row());
        innerTable.getRows().get(0).getCells().add(new Cell("Inner00"));
        innerTable.getRows().get(0).getCells().add(new Cell("Inner01"));
        innerTable.getRows().get(1).getCells().add(new Cell("Inner10"));
        innerTable.getRows().get(1).getCells().add(new Cell("Inner11"));

        innerTable.setCellsBorders(AsciiBorders.SOLID);
        innerTable.setBorder(AsciiBorders.SOLID);

        line("A Simple Table to be used as one cell");

        System.out.println(innerTable.render());

        Row row = new Row();

        /* Add a simple cell first */
        row.getCells().add(new Cell("A Cell At Left"));

        /* Add innerTable as another cell beside the former */
        row.getCells().add(innerTable);

        outerTable.getRows().add(row);

        line("Nested Tables");

        System.out.println(outerTable.render());

```

Setting Cell Width
------------------

ExampleCode4

```java
        Table table = new Table();

        table.setBorder(AsciiBorders.BOLD);

        Row row = new Row();

        table.getRows().add(row);

        Cell wrapCell = new Cell("This is a long text that hopefully will not "
                + "fit inside the cell in one line!");

        wrapCell.setMaximumWidth(20);
        wrapCell.setBorder(AsciiBorders.SOLID);
        row.getCells().add(wrapCell);

        line("Add cell that breaks long text");

        System.out.println(table.render());

```


Using TextBoxes
---------------


ExampleCode5

*Note that ExampleCode5 is placed in source packages instead of test packages. that's because I preferred to run this test in real console to see the outcome.*


```java


        InputTextBox textBox = new InputTextBox();
        
        textBox.setWidth(40);
        
        textBox.setLabel("This is going to be a logn label, it should be longer than 40 chars, then we can see if the label cell correctly breaks.");
        
        textBox.askInput();
        
        System.out.println("the value from text box: " + textBox.getValue());

```
