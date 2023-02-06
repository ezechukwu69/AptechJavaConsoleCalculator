package com.calculator.operations;

import java.util.Optional;

public class AverageOperation implements TwoValueOperation {
  @Override
  public boolean performInitialAction() {
    try {
      System.out.print("Enter numbers seperated by \",\" " + "(e.g 1,2,3,4) " + " (Type exit to quit): ");
      Optional<String> firstNumber = readInput();
      if (!firstNumber.isPresent()) {
        System.out.println("Invalid input...\n");
        return performInitialAction();
      }
      if (firstNumber.get().toLowerCase().trim().equals("exit")) {
        return false;
      }
      String[] numbers = firstNumber.get().split(",");
      Double sum = 0.0;
      Double count = Integer.valueOf(numbers.length).doubleValue();
      for (String number : numbers) {
        if (!number.isBlank() && !number.isEmpty()) {
          sum += Integer.parseInt(number.trim());
        }
      }
      Double average = sum / count;
      System.out.println("Average of " + firstNumber.get() + " is " + average + "");
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
}
