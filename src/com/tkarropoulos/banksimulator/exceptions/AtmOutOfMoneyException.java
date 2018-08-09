package com.tkarropoulos.banksimulator.exceptions;

public class AtmOutOfMoneyException extends RuntimeException {

    public AtmOutOfMoneyException(String message) {
        super(message);
    }
}
