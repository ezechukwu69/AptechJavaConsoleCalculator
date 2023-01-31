package printers;

import java.util.ArrayList;

import options.Action;

public class MenuPrinter implements Printer {

    private ArrayList<Action> mainMenuActions = new ArrayList<>();
    private ArrayList<Action> arrithMeticActions = new ArrayList<>();

    private void seedMainMenu() {
        mainMenuActions.add(new Action(1, "Arrithmetic Operations"));
        mainMenuActions.add(new Action(2, "Exit"));
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
