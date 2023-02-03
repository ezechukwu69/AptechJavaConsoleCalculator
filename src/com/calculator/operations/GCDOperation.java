package com.calculator.operations;

import java.util.Optional;

public class GCDOperation implements TwoValueOperation {

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
            Integer firstNumberValue = Integer.parseInt(firstNumber.get());
            System.out.print("Enter the second number: ");
            Optional<String> secondNumber = readInput();
            if (!secondNumber.isPresent()) {
                System.out.println("Invalid input...\n");
                return performInitialAction();
            }
            if (secondNumber.get().toLowerCase().trim().equals("exit")) {
                return false;
            }
            Integer secondNumberValue = Integer.parseInt(secondNumber.get());
            int gcd = 1;
            for (int i = 1; i <= firstNumberValue && i <= secondNumberValue; ++i) {
                // Checks if i is factor of both integers
                if (firstNumberValue % i == 0 && secondNumberValue % i == 0)
                    gcd = i;
            }

            System.out.printf("The GCD of %d and %d is %d.\n", firstNumberValue, secondNumberValue, gcd);
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
