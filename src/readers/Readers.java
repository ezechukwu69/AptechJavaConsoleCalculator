package readers;

import java.util.function.Function;

import executors.TwoValueExecutor;
import operations.AdditionOperation;
import operations.SubtractionOperation;
import printers.MenuPrinter;
import scanner.AppScanner;

public class Readers {

    private MenuPrinter menuPrinter;

    public MenuPrinter getPrinter() {
        return this.menuPrinter;
    }

    public Readers(MenuPrinter menuPrinter) {
        this.menuPrinter = menuPrinter;
    }

    private void scan(Function<Integer, Void> callback, Function<Exception, Void> errorCallBack) {
        try {
            String choice = AppScanner.scanner.nextLine();
            callback.apply(Integer.parseInt(choice));
        } catch (Exception e) {
            System.out.println("Invalid input");
            errorCallBack.apply(e);
        }
    }

    public void readArithmeticMenu() {
        scan((Integer choice) -> {
            switch (choice) {
                case 1:
                    System.out.println("\n Addition \n");
                    TwoValueExecutor.performArithmeticOperation(new AdditionOperation(), this);
                    break;
                case 2:
                    System.out.println("\n Subtraction \n");
                    TwoValueExecutor.performArithmeticOperation(new SubtractionOperation(), this);
                    break;
                case 3:
                    System.out.println("Multiplication");
                    break;
                case 4:
                    System.out.println("Division");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid input....");
                    readArithmeticMenu();
            }
            return null;
        }, (error) -> {
            menuPrinter.print(MenuPrinter.Menu.MAIN.toString());
            readMainMenu();
            return null;
        });
    }

    public void readMainMenu() {
        scan((Integer choice) -> {
            switch (choice) {
                case 1:
                    menuPrinter.print(MenuPrinter.Menu.ARITHMETIC.toString());
                    readArithmeticMenu();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    AppScanner.scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    System.out.print("Enter your choice: ");
                    readMainMenu();
            }
            return null;
        }, (error) -> {
            System.out.print("Enter your choice: ");
            readMainMenu();
            return null;
        });
    }

}
