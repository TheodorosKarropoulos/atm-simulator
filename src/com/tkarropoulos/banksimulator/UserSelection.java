package com.tkarropoulos.banksimulator;

import java.util.Scanner;

public class UserSelection {

    private Scanner scanner = new Scanner(System.in);
    private static int userSelection;

    private final static AtmDisplayMenu atmDisplayMenu = new AtmDisplayMenu();

    private ATMMachine atmMachine;

    protected UserSelection() {

    }

    public UserSelection(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    public void menuActions () {
        userSelection = scanner.nextInt();
        while(userSelection < 1 || userSelection > 4) {
            atmDisplayMenu.displayMenu();
            userSelection = scanner.nextInt();
        }
        this.mainMenuActions();
    }

    public void mainMenuActions() {
        int amount;
        switch (this.getUserSelection()) {
            case 1:
                System.out.print("Enter amount to withdraw $");
                amount = scanner.nextInt();
                atmMachine.requestWithdraw(amount);
                this.displayBackToMainMenuOrExitSelection();
                break;
            case 2:
                System.out.print("Enter amount to deposit $");
                amount = scanner.nextInt();
                atmMachine.depositMoney(amount);
                this.displayBackToMainMenuOrExitSelection();
                break;
            case 3:
                System.out.println("Your account balance is is $" + atmMachine.getAtmAmount());
                this.displayBackToMainMenuOrExitSelection();
                break;
            case 4:
                System.exit(0);
                break;
                default:
                    atmDisplayMenu.displayWrongSelectionText();
                    break;
        }
    }

    private void displayBackToMainMenuOrExitSelection() {
        atmDisplayMenu.displayBackToMainMenu();
        userSelection = scanner.nextInt();
        while(userSelection < 1 || userSelection > 2) {
            atmDisplayMenu.displayBackToMainMenu();
            userSelection = scanner.nextInt();
        }
        this.backToMainMenuOrExitSelection();
    }
    private void backToMainMenuOrExitSelection() {
        switch (this.getUserSelection()) {
            case 1:
                atmDisplayMenu.displayMenu();
                this.menuActions();
                break;
            case 2:
                System.exit(0);
                break;
                default:
                    atmDisplayMenu.displayWrongSelectionText();
                    break;
        }
    }

    public static int getUserSelection() {
        return userSelection;
    }
}
