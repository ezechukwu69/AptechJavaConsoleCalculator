package com.calculator.operations;

import java.util.Optional;

public class ArithmeticOperation implements TwoValueOperation {

  public ArithmeticOperationType type;
  private String symbol;

  public ArithmeticOperation(ArithmeticOperationType type) {
    this.type = type;
    switch (type) {
      case ADDITION:
        symbol = "+";
        break;
      case SUBTRACTION:
        symbol = "-";
        break;
      case DIVISION:
        symbol = "/";
        break;
      case MULTIPLICATION:
        symbol = "X";
        break;
    }
  }

  Double runArithmetic(double firstNumber, double secondNumber) {
    switch (type) {
      case ADDITION:
        return Double.valueOf(firstNumber + secondNumber);
      case SUBTRACTION:
        return Double.valueOf(firstNumber - secondNumber);
      case DIVISION:
        return Double.valueOf(firstNumber / secondNumber);
      case MULTIPLICATION:
        return Double.valueOf(firstNumber * secondNumber);
    }
    return 0.0;
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
      Double sum = runArithmetic(firstNumberValue, secondNumberValue);
      return performSubsequentAction(sum);
    } catch (Exception e) {
      System.out.println("Invalid input...\n");
      return performInitialAction();
    }
  }

  @Override
  public boolean performSubsequentAction(Double firstNumber) {
    System.out.print("(Type exit to quit) " + firstNumber + " " + symbol + " ");
    Optional<String> secondNumber = readInput();
    try {
      if (!secondNumber.isPresent()) {
        System.out.println("Invalid input...\n");
        return performSubsequentAction(firstNumber);
      }
      if (secondNumber.get().toLowerCase().trim().equals("exit")) {
        return false;
      }
      Double secondNumberValue = Double.parseDouble(secondNumber.get());
      Double sum = runArithmetic(firstNumber, secondNumberValue);
      return performSubsequentAction(sum);
    } catch (Exception e) {
      System.out.println("Invalid input...\n");
      return performSubsequentAction(firstNumber);
    }
  }

  public enum ArithmeticOperationType {
    ADDITION,
    SUBTRACTION,
    DIVISION,
    MULTIPLICATION
  }
}
