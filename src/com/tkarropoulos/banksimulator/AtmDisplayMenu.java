package com.tkarropoulos.banksimulator;

public class AtmDisplayMenu {

    public AtmDisplayMenu() {
    }

    // Private methods
    private final static void displayWelcomeText() {
        System.out.println("Welcome to My ATM Machine");
    }

    private final static void displayChooseActionText() {
        System.out.println("Please choose one of the following actions");
    }

    private final static void displayWithdrawSelectionText(int index) {
        System.out.println(index + ". Withdraw");
    }

    private final static void displayDepositSelectionText(int index) {
        System.out.println(index + ". Deposit");
    }

    private final static void displayRemainingAmountSelectionText(int index) {
        System.out.println(index + ". Display remaining amount");
    }

    private final static void displayExitSelectionText(int index) {
        System.out.println(index + ". Exit");
    }

    private final static void displayBackToMainMenuText(int index) {
        System.out.println(index + ". Back to main menu");
    }

    private static final void displayDoubleDashes() {
        System.out.println("=====================================================================");
    }

    private final static void displayEnterYourSelectionHere() {
        System.out.print("Enter your selection here: ");
    }

    // Protected methods

    protected void displayMenu() {
        this.displayWithdrawSelectionText(1);
        this.displayDepositSelectionText(2);
        this.displayRemainingAmountSelectionText(3);
        this.displayExitSelectionText(4);
        this.displayDoubleDashes();
        this.displayEnterYourSelectionHere();
    }

    protected void displayWelcomeMessage() {
        this.displayWelcomeText();
        this.displayChooseActionText();
        this.displayDoubleDashes();
    }

    protected void displayBackToMainMenu() {
        this.displayBackToMainMenuText(1);
        this.displayExitSelectionText(2);
        this.displayEnterYourSelectionHere();
    }

    protected static final void displayDashes() {
        System.out.println("---------------------------------------------------------------------");
    }

    protected final static void displayWrongSelectionText() {
        System.out.println("Wrong user selection");
    }

}
