package com.calculator.operations;

import java.util.Optional;

import com.calculator.scanner.AppScanner;

public class SubtractionOperation implements TwoValueOperation {

    public Optional<String> readInput() {
        try {
            String data = AppScanner.scanner.nextLine();
            return Optional.of(data);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Invalid input");
            return readInput();
        }
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
            Integer sum = firstNumberValue - secondNumberValue;
            return performSubsequentAction(sum);
        } catch (Exception e) {
            System.out.println("Invalid input...\n");
            return performInitialAction();
        }
    }

    @Override
    public boolean performSubsequentAction(Integer firstNumber) {
        System.out.print("(Type exit to quit) " + firstNumber + " - ");

        Optional<String> secondNumber = readInput();
        try {
            if (!secondNumber.isPresent()) {
                System.out.println("Invalid input...\n");
                return performSubsequentAction(firstNumber);
            }
            if (secondNumber.get().toLowerCase().trim().equals("exit")) {
                return false;
            }
            Integer secondNumberValue = Integer.parseInt(secondNumber.get());
            Integer sum = firstNumber - secondNumberValue;
            return performSubsequentAction(sum);
        } catch (Exception e) {
            System.out.println("Invalid input...\n");
            return performSubsequentAction(firstNumber);
        }
    }

}
