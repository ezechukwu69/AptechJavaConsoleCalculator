package com.calculator.printers;

import java.util.ArrayList;

import com.calculator.options.Action;

public class MenuPrinter implements Printer {

  private ArrayList<Action> mainMenuActions = new ArrayList<>();
  private ArrayList<Action> arrithMeticActions = new ArrayList<>();
  private ArrayList<Action> trigonometricActions = new ArrayList<>();
  private ArrayList<Action> mathActions = new ArrayList<>();
  private ArrayList<Action> advancedArrithmeticActions = new ArrayList<>();

  private void seedMainMenu() {
    mainMenuActions.add(new Action(1, "Arrithmetic Operations"));
    mainMenuActions.add(new Action(2, "Advanced Arrithmetic Operations"));
    mainMenuActions.add(new Action(3, "Math Operations"));
    mainMenuActions.add(new Action(4, "Trigonometric Operations"));
    mainMenuActions.add(new Action(5, "Exponential Operations"));
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

  private void seedAdvancedArrithMeticActions() {
    advancedArrithmeticActions.add(new Action(1, "Power"));
    advancedArrithmeticActions.add(new Action(2, "Square"));
    advancedArrithmeticActions.add(new Action(3, "Cube"));
    advancedArrithmeticActions.add(new Action(4, "Square root"));
    advancedArrithmeticActions.add(new Action(5, "Back"));
  }

  private void seedMathActions() {
    mathActions.add(new Action(1, "Round"));
    mathActions.add(new Action(2, "Ceiling"));
    mathActions.add(new Action(3, "Floor"));
    mathActions.add(new Action(4, "Min Value"));
    mathActions.add(new Action(5, "Max Value"));
    mathActions.add(new Action(6, "Back"));
  }

  private void seedTrigonometricActions() {
    trigonometricActions.add(new Action(1, "Sine"));
    trigonometricActions.add(new Action(2, "Cosine"));
    trigonometricActions.add(new Action(3, "Tangent"));
    trigonometricActions.add(new Action(4, "ASINE"));
    trigonometricActions.add(new Action(5, "ACOSINE"));
    trigonometricActions.add(new Action(6, "ATANGENT"));
    trigonometricActions.add(new Action(7, "Back"));
  }

  public MenuPrinter() {
    seedMainMenu();
    seedArrithMeticActions();
    seedTrigonometricActions();
    seedAdvancedArrithMeticActions();
    seedMathActions();
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
    MAIN, ARITHMETIC, ADVANCED_ARITHMETIC, MATH, TRIGONOMETRY
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
      case "ADVANCED_ARITHMETIC":
        print(advancedArrithmeticActions);
        break;
      case "MATH":
        print(mathActions);
        break;
      case "TRIGONOMETRY":
        print(trigonometricActions);
        break;
    }

  }

}
