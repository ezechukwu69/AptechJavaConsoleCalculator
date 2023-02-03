package com.calculator.operations;

import java.util.Optional;

public class AmstrongOperation implements TwoValueOperation {
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
            Integer total = Integer.parseInt(firstNumber.get().trim());
            String[] numbers = firstNumber.get().split("");
            int base = numbers.length;
            int sum = 0;
            for (String number : numbers) {
                sum += Math.pow(Integer.parseInt(number), base);
            }
            if (sum == total) {
                System.out.println(total + " is an amstrong number.");
            } else {
                System.out.println(total + " is not an amstrong number.");
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
