package com.calculator.readers;

import java.util.function.Function;

import com.calculator.executors.TwoValueExecutor;
import com.calculator.operations.AdvancedArrithmetic;
import com.calculator.operations.AdvancedArrithmetic.AArithmeticType;
import com.calculator.operations.AmstrongOperation;
import com.calculator.operations.ArithmeticOperation;
import com.calculator.operations.ArithmeticOperation.ArithmeticOperationType;
import com.calculator.operations.MathOperations.MathOperationType;
import com.calculator.operations.TrigonometricOperations.TrigonometricType;
import com.calculator.operations.AverageOperation;
import com.calculator.operations.ExponentialOperation;
import com.calculator.operations.GCDOperation;
import com.calculator.operations.LCMOperatios;
import com.calculator.operations.MathOperations;
import com.calculator.operations.PalindromeOperation;
import com.calculator.operations.PrimeOperation;
import com.calculator.operations.TrigonometricOperations;
import com.calculator.printers.MenuPrinter;
import com.calculator.scanner.AppScanner;

public class Readers {

  private final MenuPrinter menuPrinter;

  public MenuPrinter getPrinter() {
    return this.menuPrinter;
  }

  public Readers(final MenuPrinter menuPrinter) {
    this.menuPrinter = menuPrinter;
  }

  private void scan(final Function<Integer, Void> callback, final Function<Exception, Void> errorCallBack) {
    try {
      final String choice = AppScanner.scanner.nextLine();
      callback.apply(Integer.parseInt(choice));
    } catch (final Exception e) {
      System.out.println("Invalid input");
      errorCallBack.apply(e);
    }
  }

  public void readArithmeticMenu() {
    scan((final Integer choice) -> {
      switch (choice) {
        case 1:
          System.out.println("\n Addition \n");
          TwoValueExecutor.performArithmeticOperation(new ArithmeticOperation(ArithmeticOperationType.ADDITION), this);
          break;
        case 2:
          System.out.println("\n Subtraction \n");
          TwoValueExecutor.performArithmeticOperation(new ArithmeticOperation(ArithmeticOperationType.SUBTRACTION),
              this);
          break;
        case 3:
          System.out.println("Multiplication");
          TwoValueExecutor.performArithmeticOperation(new ArithmeticOperation(ArithmeticOperationType.MULTIPLICATION),
              this);
          break;
        case 4:
          System.out.println("Division");
          TwoValueExecutor.performArithmeticOperation(new ArithmeticOperation(ArithmeticOperationType.DIVISION), this);
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

  public void readAdvancedArrithmeticMenu() {
    scan((final Integer choice) -> {
      switch (choice) {
        case 1:
          System.out.println("\n Power \n");
          TwoValueExecutor.performAdvancedArithmeticOperation(new AdvancedArrithmetic(AArithmeticType.POWER), this);
          break;
        case 2:
          System.out.println("\n Square \n");
          TwoValueExecutor.performAdvancedArithmeticOperation(new AdvancedArrithmetic(AArithmeticType.SQUARE), this);
          break;
        case 3:
          System.out.println("\n Cube \n");
          TwoValueExecutor.performAdvancedArithmeticOperation(new AdvancedArrithmetic(AArithmeticType.CUBE), this);
          break;
        case 4:
          System.out.println("\n Square Root \n");
          TwoValueExecutor.performAdvancedArithmeticOperation(new AdvancedArrithmetic(AArithmeticType.SQUARE_ROOT),
              this);
          break;
        case 5:
          break;
        default:
          System.out.println("Invalid input....");
          readAdvancedArrithmeticMenu();
      }
      return null;
    }, (error) -> {
      menuPrinter.print(MenuPrinter.Menu.MAIN.toString());
      readMainMenu();
      return null;
    });
  }

  public void readAdvancedMathMenu() {
    scan((final Integer choice) -> {
      switch (choice) {
        case 1:
          System.out.println("\n Round \n");
          TwoValueExecutor.performMathOperation(new MathOperations(MathOperationType.ROUND), this);
          break;
        case 2:
          System.out.println("\n Ceiling \n");
          TwoValueExecutor.performMathOperation(new MathOperations(MathOperationType.CEILING), this);
          break;
        case 3:
          System.out.println("\n Floor \n");
          TwoValueExecutor.performMathOperation(new MathOperations(MathOperationType.FLOOR), this);
          break;
        case 4:
          System.out.println("\n Min Value \n");
          TwoValueExecutor.performMathOperation(new MathOperations(MathOperationType.MIN_VALUE), this);
          break;
        case 5:
          System.out.println("\n Max Value \n");
          TwoValueExecutor.performMathOperation(new MathOperations(MathOperationType.MAX_VALUE), this);
          break;
        case 6:
          break;
        default:
          System.out.println("Invalid input....");
          readAdvancedMathMenu();
      }
      return null;
    }, (error) -> {
      menuPrinter.print(MenuPrinter.Menu.MAIN.toString());
      readMainMenu();
      return null;
    });
  }

  public void readTrigonometricMenu() {
    scan((final Integer choice) -> {
      switch (choice) {
        case 1:
          System.out.println("\n Sine \n");
          TwoValueExecutor.performTrigonometricOperation(new TrigonometricOperations(TrigonometricType.SIN), this);
          break;
        case 2:
          System.out.println("\n Cosine \n");
          TwoValueExecutor.performTrigonometricOperation(new TrigonometricOperations(TrigonometricType.COSINE), this);
          break;
        case 3:
          System.out.println("\n Tangent \n");
          TwoValueExecutor.performTrigonometricOperation(new TrigonometricOperations(TrigonometricType.TANGENT), this);
          break;
        case 4:
          System.out.println("\n ASine \n");
          TwoValueExecutor.performTrigonometricOperation(new TrigonometricOperations(TrigonometricType.ASIN), this);
          break;
        case 5:
          System.out.println("\n ACosine \n");
          TwoValueExecutor.performTrigonometricOperation(new TrigonometricOperations(TrigonometricType.ACOSINE), this);
          break;
        case 6:
          System.out.println("\n ATangent \n");
          TwoValueExecutor.performTrigonometricOperation(new TrigonometricOperations(TrigonometricType.ATANGENT), this);
          break;
        case 7:
          break;
        default:
          System.out.println("Invalid input....");
          readTrigonometricMenu();
      }
      return null;
    }, (error) -> {
      menuPrinter.print(MenuPrinter.Menu.MAIN.toString());
      readMainMenu();
      return null;
    });
  }

  public void readMainMenu() {
    scan((final Integer choice) -> {
      switch (choice) {
        case 1:
          menuPrinter.print(MenuPrinter.Menu.ARITHMETIC.toString());
          readArithmeticMenu();
          break;
        case 2:
          menuPrinter.print(MenuPrinter.Menu.ADVANCED_ARITHMETIC.toString());
          readAdvancedArrithmeticMenu();
          break;
        case 3:
          menuPrinter.print(MenuPrinter.Menu.MATH.toString());
          readAdvancedMathMenu();
          break;
        case 4:
          menuPrinter.print(MenuPrinter.Menu.TRIGONOMETRY.toString());
          readTrigonometricMenu();
          break;
        case 5:
          System.out.println("\n Exponential function \n");
          TwoValueExecutor.performOperation(new ExponentialOperation());
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
