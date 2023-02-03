package com.calculator.executors;

import java.util.function.Function;

import com.calculator.operations.TwoValueOperation;
import com.calculator.printers.MenuPrinter;
import com.calculator.readers.Readers;

public class TwoValueExecutor {
    private static void performTwoValueOperation(TwoValueOperation twoValueOperation, Function<Void, Void> callable) {
        while (twoValueOperation.performInitialAction()) {
        }
        callable.apply(null);
    }

    public static void performArithmeticOperation(TwoValueOperation twoValueOperation, Readers readers) {
        performTwoValueOperation(twoValueOperation, (v) -> {
            readers.getPrinter().print(MenuPrinter.Menu.ARITHMETIC.toString());
            readers.readArithmeticMenu();
            return null;
        });
    };

    public static void performOperation(TwoValueOperation twoValueOperation) {
        performTwoValueOperation(twoValueOperation, (v) -> {
            return null;
        });
    };
}
