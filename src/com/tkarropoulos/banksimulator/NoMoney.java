package com.tkarropoulos.banksimulator;

import com.tkarropoulos.banksimulator.exceptions.AtmOutOfMoneyException;

public class NoMoney implements State {

    private static ATMMachine atmMachine;

    public NoMoney(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void withdrawMoney(int amount) {
        throw new AtmOutOfMoneyException("ATM is out of money. Please try again later.");
    }

    @Override
    public void depositMoney(int amount) {

    }
}
