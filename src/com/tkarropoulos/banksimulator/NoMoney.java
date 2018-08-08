package com.tkarropoulos.banksimulator;

public class NoMoney implements State {

    private static ATMMachine atmMachine;

    public NoMoney(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void withdrawMoney(int amount) {
        System.out.println("ATM is out of money. Please try again later.");
    }

    @Override
    public void depositMoney(int amount) {

    }
}
