
package com.calculator.operations;

import java.util.Optional;

public class ExponentialOperation implements TwoValueOperation {

  public ExponentialOperation() {
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
      System.out.printf("The exponent of %f is %f.\n",
          firstNumberValue,
          Math.exp(firstNumberValue));
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
}
