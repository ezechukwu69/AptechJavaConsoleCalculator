package com.calculator;

import com.calculator.printers.MenuPrinter;
import com.calculator.printers.MenuPrinter.Menu;
import com.calculator.readers.Readers;

public class Main {
    public static void main(String[] args) throws Exception {
        MenuPrinter menuPrinter = new MenuPrinter();
        menuPrinter.printWelcomeMessage();
        while (true) {
            menuPrinter.print(Menu.MAIN.toString());
            Readers readers = new Readers(menuPrinter);
            readers.readMainMenu();
        }
    }
}
