package com.tkarropoulos.banksimulator;

public class Main {

    public static void main(String[] args) {
        ATMMachine atmMachine = new ATMMachine();
        atmMachine.run(atmMachine);
    }
}
