package com.calculator.readers;

import java.util.function.Function;

import com.calculator.executors.TwoValueExecutor;
import com.calculator.operations.AdditionOperation;
import com.calculator.operations.AmstrongOperation;
import com.calculator.operations.AverageOperation;
import com.calculator.operations.GCDOperation;
import com.calculator.operations.LCMOperatios;
import com.calculator.operations.PalindromeOperation;
import com.calculator.operations.PrimeOperation;
import com.calculator.operations.SubtractionOperation;
import com.calculator.printers.MenuPrinter;
import com.calculator.scanner.AppScanner;

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
                case 6:
                    System.out.println("\n Palindrome number \n");
                    TwoValueExecutor.performOperation(new PalindromeOperation());
                    break;
                case 7:
                    System.out.println("\n Amstrong number \n");
                    TwoValueExecutor.performOperation(new AmstrongOperation());
                    break;
                case 8:
                    System.out.println("\n Prime number \n");
                    TwoValueExecutor.performOperation(new PrimeOperation());
                    break;
                case 9:
                    System.out.println("\n Average \n");
                    TwoValueExecutor.performOperation(new AverageOperation());
                    break;
                case 10:
                    System.out.println("\n GCD \n");
                    TwoValueExecutor.performOperation(new GCDOperation());
                    break;
                case 11:
                    System.out.println("\n LCM \n");
                    TwoValueExecutor.performOperation(new LCMOperatios());
                    break;
                case 12:
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
