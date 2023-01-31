import printers.MenuPrinter;
import printers.MenuPrinter.Menu;
import readers.Readers;

public class App {
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
