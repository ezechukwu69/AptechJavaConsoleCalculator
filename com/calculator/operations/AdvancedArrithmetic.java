
package com.calculator.operations;

import java.util.Optional;

public class AdvancedArrithmetic implements TwoValueOperation {

  public AArithmeticType type;

  public AdvancedArrithmetic(AArithmeticType type) {
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
      double value = 0.0;
      System.out.println(type);
      switch (type) {
        case POWER:
          typeChecked = "power (**)";
          System.out.print("Enter the power: ");
          Optional<String> secondNumber = readInput();
          if (!secondNumber.isPresent()) {
            System.out.println("Invalid input...\n");
            return performInitialAction();
          }
          if (firstNumber.get().toLowerCase().trim().equals("exit")) {
            return false;
          }
          Double secondNumberValue = Double.parseDouble(secondNumber.get());
          value = Math.pow(firstNumberValue, secondNumberValue);
          break;
        case SQUARE:
          typeChecked = "square";
          value = Math.pow(firstNumberValue, 2);
          break;
        case CUBE:
          typeChecked = "cube";
          value = Math.pow(firstNumberValue, 3);
          break;
        case SQUARE_ROOT:
          typeChecked = "square root";
          value = Math.sqrt(firstNumberValue);
          break;
      }
      System.out.println(value);
      System.out.printf("The " + typeChecked + " of %f is %f.\n", firstNumberValue, value);
      return false;
    } catch (Exception e) {
      System.out.println("Invalid input... " + e + "\n");
      return performInitialAction();
    }
  }

  @Override
  public boolean performSubsequentAction(Double firstNumber) {
    throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                   // Tools | Templates.
  }

  public enum AArithmeticType {
    POWER,
    SQUARE,
    CUBE,
    SQUARE_ROOT
  }
}
