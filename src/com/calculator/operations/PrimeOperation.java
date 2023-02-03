package com.calculator.operations;

import java.util.Optional;

public class PrimeOperation implements TwoValueOperation {
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
            Integer firstNumberValue = Integer.parseInt(firstNumber.get().trim());
            boolean check = false;
            for (int i = 2; i <= firstNumberValue / 2; ++i) {
                // condition for nonprime number
                if (firstNumberValue % i == 0) {
                    check = true;
                    break;
                }
            }
            if (!check)
                System.out.println(firstNumberValue + " is a prime number.");
            else
                System.out.println(firstNumberValue + " is not a prime number.");
            return false;
        } catch (Exception e) {
            System.out.println("Invalid input...\n");
            return performInitialAction();
        }
    }

    @Override
    public boolean performSubsequentAction(Integer firstNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }
}
