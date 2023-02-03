package com.calculator.operations;

import java.util.Optional;

public class PalindromeOperation implements TwoValueOperation {
    @Override
    public boolean performInitialAction() {
        try {
            System.out.print("Enter number: ");
            Optional<String> firstNumber = readInput();
            if (!firstNumber.isPresent()) {
                System.out.println("Invalid input...\n");
                return performInitialAction();
            }
            if (firstNumber.get().toLowerCase().trim().equals("exit")) {
                return false;
            }
            Integer total = Integer.parseInt(firstNumber.get().trim());
            String reversedNumber = new StringBuilder(firstNumber.get()).reverse().toString();

            if (firstNumber.get().equals(reversedNumber)) {
                System.out.println(total + " is a palindrome number.");
            } else {
                System.out.println(total + " is not a palindrome number.");
            }
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
