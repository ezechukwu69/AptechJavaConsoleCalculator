
package com.calculator.operations;

import java.util.Optional;

public class MathOperations implements TwoValueOperation {

  public MathOperationType type;

  public MathOperations(MathOperationType type) {
    this.type = type;
  }

  @Override
  public boolean performInitialAction() {
    try {
      System.out.print("Enter the number: ");
      Optional<String> firstNumber = readInput();
      if (!firstNumber.isPresent()) {
        System.out.println("Invalid input...\n");
        return performInitialAction();
      }
      if (firstNumber.get().toLowerCase().trim().equals("exit")) {
        return false;
      }
      Double firstNumberValue = Double.parseDouble(firstNumber.get());
      String typeChecked = "";
      double value = 0;
      switch (type) {
        case MIN_VALUE:
          typeChecked = "MIN VALUE";
          System.out.print("Enter the second number: ");
          Optional<String> secondNumber = readInput();
          if (!secondNumber.isPresent()) {
            System.out.println("Invalid input...\n");
            return performInitialAction();
          }
          if (secondNumber.get().toLowerCase().trim().equals("exit")) {
            return false;
          }
          Double secondNumberValue = Double.parseDouble(secondNumber.get());
          value = Math.min(firstNumberValue, secondNumberValue);
          System.out.printf("The " + typeChecked + " of %f and %f is %f.\n", firstNumberValue, secondNumberValue,
              value);
          return false;
        case MAX_VALUE:
          typeChecked = "MAX VALUE";
          System.out.print("Enter the second number: ");
          Optional<String> secondNumber2 = readInput();
          if (!secondNumber2.isPresent()) {
            System.out.println("Invalid input...\n");
            return performInitialAction();
          }
          if (secondNumber2.get().toLowerCase().trim().equals("exit")) {
            return false;
          }
          Double secondNumberValue2 = Double.parseDouble(secondNumber2.get());
          value = Math.max(firstNumberValue, secondNumberValue2);
          System.out.printf("The " + typeChecked + " of %f and %f is %f.\n", firstNumberValue, secondNumberValue2,
              value);
          return false;
        case CEILING:
          typeChecked = "ceiling";
          value = Math.ceil(firstNumberValue);
          break;
        case FLOOR:
          typeChecked = "ceiling";
          value = Math.floor(firstNumberValue);
          break;
        case ROUND:
          typeChecked = "round";
          value = Math.round(firstNumberValue);
          break;
      }
      System.out.printf("The " + typeChecked + " of %f is %f.\n", firstNumberValue, value);
      return false;
    } catch (Exception e) {
      System.out.println("Invalid input...\n");
      return performInitialAction();
    }
  }

  @Override
  public boolean performSubsequentAction(Double firstNumber) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public enum MathOperationType {
    ROUND,
    CEILING,
    FLOOR,
    MIN_VALUE,
    MAX_VALUE
  }
}
