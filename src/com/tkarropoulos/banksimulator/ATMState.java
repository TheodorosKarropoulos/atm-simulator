package com.tkarropoulos.banksimulator;

public class ATMState implements State{

    private static ATMMachine atmMachine;

    public ATMState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void withdrawMoney(int amount) {
        System.out.println("Withdrawing $" + amount);
        if(amount > atmMachine.atmAmount) {
            System.out.println("Transaction can not be completed. Not enough money in your bank account");
            System.out.println("Your account balance is $" + atmMachine.atmAmount);
        } else {
            atmMachine.setAtmAmount(atmMachine.atmAmount - amount);
            System.out.println("New account balance is $" + atmMachine.getAtmAmount());
        }
    }

    @Override
    public void depositMoney(int amount) {
        System.out.println("Depositing $" + amount);
        atmMachine.setAtmAmount(atmMachine.atmAmount + amount);
        System.out.println("New account balance is $" + atmMachine.getAtmAmount());
    }
}
