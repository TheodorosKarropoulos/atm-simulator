package com.tkarropoulos.banksimulator.exceptions;

public class WrongGivenAmountException extends RuntimeException  {


    public WrongGivenAmountException(String message) {
        super(message);
    }
}
