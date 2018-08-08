package com.tkarropoulos.banksimulator;

public interface State {

    void withdrawMoney(int amount);
    void depositMoney(int amount);

}
