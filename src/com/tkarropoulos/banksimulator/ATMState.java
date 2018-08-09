package com.tkarropoulos.banksimulator;

import com.tkarropoulos.banksimulator.exceptions.InsufficientAccountBalanceException;
import com.tkarropoulos.banksimulator.exceptions.WrongGivenAmountException;

import static com.tkarropoulos.banksimulator.StaticValues.FIFTY_EURO_VALUE;
import static com.tkarropoulos.banksimulator.StaticValues.TWENTY_EURO_VALUE;

public class ATMState implements State{

    private static ATMMachine atmMachine;

    public ATMState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void withdrawMoney(int amount) {
        try {
            if(amount % FIFTY_EURO_VALUE != 0 && amount % TWENTY_EURO_VALUE != 0) {
                throw new WrongGivenAmountException("Wrong amount given");
            } else {
                try {
                    if(amount > atmMachine.getAtmAmount()) {
                        throw new InsufficientAccountBalanceException("Transaction can not be completed. Not enough money in your bank account\n" +
                                "Your account balance is $" + atmMachine.getAtmAmount());
                    } else {
                        if(atmMachine.getBankNotes().withdrawBankNotes(amount)) {
                            System.out.println("Withdrawing $" + amount);
                            atmMachine.setAtmAmount(atmMachine.getAtmAmount() - amount);
                            System.out.println("New account balance is $" + atmMachine.getAtmAmount());
                        } else {
                            System.out.println("Transaction can not be completed. Please try again later");
                        }
                    }
                }catch (InsufficientAccountBalanceException e) {
                    System.out.println("Transaction can not be completed. Not enough money in your bank account");
                    System.out.println("Your account balance is $" + atmMachine.getAtmAmount());
                }
            }
        }catch (WrongGivenAmountException e) {
            System.out.println("Wrong amount given");
        }
    }

    @Override
    public void depositMoney(int amount) {

        try {
            if(amount % FIFTY_EURO_VALUE != 0 && amount % TWENTY_EURO_VALUE != 0)
                throw new WrongGivenAmountException("Wrong amount given");
            System.out.println("Depositing $" + amount);
            atmMachine.setAtmAmount(atmMachine.getAtmAmount() + amount);
            System.out.println("New account balance is $" + atmMachine.getAtmAmount());
        } catch (WrongGivenAmountException e) {
            System.out.println("Wrong amount given");
        }
    }


}
