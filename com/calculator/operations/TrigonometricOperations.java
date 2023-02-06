
package com.calculator.operations;

import java.util.Optional;

public class TrigonometricOperations implements TwoValueOperation {

  private TrigonometricType type;

  public TrigonometricOperations(TrigonometricType type) {
    this.type = type;
  }

  @Override
  public boolean performInitialAction() {
    try {
      System.out.print("Enter the first number: ");
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
        case SIN:
          typeChecked = "sin";
          value = Math.sin(firstNumberValue);
          break;
        case ASIN:
          typeChecked = "sin";
          value = Math.sin(firstNumberValue);
          break;
        case COSINE:
          typeChecked = "sin";
          value = Math.sin(firstNumberValue);
          break;
        case ACOSINE:
          typeChecked = "sin";
          value = Math.sin(firstNumberValue);
          break;
        case TANGENT:
          typeChecked = "sin";
          value = Math.sin(firstNumberValue);
          break;
        case ATANGENT:
          typeChecked = "sin";
          value = Math.sin(firstNumberValue);
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
    throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                   // Tools | Templates.
  }

  public enum TrigonometricType {
    SIN,
    COSINE,
    TANGENT,
    ASIN,
    ACOSINE,
    ATANGENT
  }
}
