package com.tkarropoulos.banksimulator;

public class ATMMachine {

    private State atmOutOfMoney;
    private State atmState;
    private State actionState;

    static int atmAmount = 2000;

    private final static AtmDisplayMenu atmDisplayMenu = new AtmDisplayMenu();

    public ATMMachine() {
        atmOutOfMoney = new NoMoney(this);

        if (atmAmount <= 0) {
            atmState = atmOutOfMoney;
        } else {
            actionState = new ATMState(this);
            atmState = actionState;
        }
    }

    public void run(ATMMachine atmMachine) {
        final UserSelection userSelection = new UserSelection(atmMachine);

        atmDisplayMenu.displayWelcomeMessage();
        atmDisplayMenu.displayMenu();
        userSelection.menuActions();
    }

    public void requestWithdraw(int amount){
        atmState.withdrawMoney(amount);
        atmDisplayMenu.displayDashes();
    }

    public void depositMoney(int amount) {
        atmState.depositMoney(amount);
        atmDisplayMenu.displayDashes();
    }

    public void setAtmAmount(int atmAmount) {
        this.atmAmount = atmAmount;
    }

    public int getAtmAmount() {
        return atmAmount;
    }

}
