package executors;

import java.util.function.Function;

import operations.TwoValueOperation;
import printers.MenuPrinter;
import readers.Readers;

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
}
