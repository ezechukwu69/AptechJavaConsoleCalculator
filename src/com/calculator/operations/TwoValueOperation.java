package com.calculator.operations;

public interface TwoValueOperation {
    public boolean performInitialAction();

    public boolean performSubsequentAction(Integer firstNumber);
}
