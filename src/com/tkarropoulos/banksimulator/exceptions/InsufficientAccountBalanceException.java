package com.tkarropoulos.banksimulator.exceptions;

public class InsufficientAccountBalanceException extends RuntimeException {

    public InsufficientAccountBalanceException(String message) {
        super(message);
    }
}
