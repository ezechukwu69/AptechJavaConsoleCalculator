package com.calculator.operations;

import java.util.Optional;

import com.calculator.scanner.AppScanner;

public interface TwoValueOperation {

  default public Optional<String> readInput() {
    try {
      String data = AppScanner.scanner.nextLine();
      return Optional.of(data);
    } catch (Exception e) {
      System.out.println(e.toString());
      System.out.println("Invalid input");
      return readInput();
    }
  }

  public boolean performInitialAction();

  public boolean performSubsequentAction(Double firstNumber);
}
