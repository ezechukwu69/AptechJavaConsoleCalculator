package com.calculator.printers;

import java.util.ArrayList;

import com.calculator.options.Action;

public class MenuPrinter implements Printer {

    private ArrayList<Action> mainMenuActions = new ArrayList<>();
    private ArrayList<Action> arrithMeticActions = new ArrayList<>();

    private void seedMainMenu() {
        mainMenuActions.add(new Action(1, "Arrithmetic Operations"));
        mainMenuActions.add(new Action(6, "Palindrome number"));
        mainMenuActions.add(new Action(7, "Amstrong number"));
        mainMenuActions.add(new Action(8, "Prime number"));
        mainMenuActions.add(new Action(9, "Average"));
        mainMenuActions.add(new Action(10, "GCD"));
        mainMenuActions.add(new Action(11, "LCM"));
        mainMenuActions.add(new Action(12, "Exit"));
    }

    private void seedArrithMeticActions() {
        arrithMeticActions.add(new Action(1, "Addition"));
        arrithMeticActions.add(new Action(2, "Subtraction"));
        arrithMeticActions.add(new Action(3, "Multiplication"));
        arrithMeticActions.add(new Action(4, "Division"));
        arrithMeticActions.add(new Action(5, "Back"));
    }

    public MenuPrinter() {
        seedMainMenu();
        seedArrithMeticActions();
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to the calculator!");
    }

    private void print(ArrayList<Action> actions) {
        System.out.println("\nSelect an option: \n");
        for (Action action : actions) {
            System.out.println(action.number() + ". " + action.action());
        }
        System.out.print("Enter your choice: ");
    }

    public enum Menu {
        MAIN, ARITHMETIC
    }

    @Override
    public void print(String message) {
        switch (message) {
            case "MAIN":
                print(mainMenuActions);
                break;
            case "ARITHMETIC":
                print(arrithMeticActions);
                break;
        }

    }

}
