package com.tkarropoulos.banksimulator;

import java.util.HashMap;
import java.util.Map;

import static com.tkarropoulos.banksimulator.StaticValues.FIFTY_EURO_VALUE;
import static com.tkarropoulos.banksimulator.StaticValues.TWENTY_EURO_VALUE;

public class BankNotes {

    private HashMap<Integer, Integer> bankNotesMap = new HashMap<>();

    protected BankNotes() {
        bankNotesMap.put(50, 1);
        bankNotesMap.put(20, 10);
    }

    public HashMap<Integer, Integer> getBankNotesMap() {
        return bankNotesMap;
    }

    public void setBankNotesMap(HashMap<Integer, Integer> bankNotesMap) {
        this.bankNotesMap = bankNotesMap;
    }

    public int getTwentyEuroNotesAmount() {
        return this.getBankNotesMap().get(TWENTY_EURO_VALUE) * TWENTY_EURO_VALUE;
    }

    public int getFiftyEuroNotesAmount() {
        return this.getBankNotesMap().get(FIFTY_EURO_VALUE) * FIFTY_EURO_VALUE;
    }

    public boolean withdrawBankNotes(int amount) {

        boolean returnValue = false;
        int remainingAmount = amount;

        HashMap<Integer, Integer> neededBankNotes = new HashMap<>();

        if(amount % FIFTY_EURO_VALUE != 0 && amount % TWENTY_EURO_VALUE != 0)
            return returnValue;

        while(remainingAmount > 0) {
            int subAmount = 0;

            for (Map.Entry entry : bankNotesMap.entrySet()) {
                Integer mapKey = (int) entry.getKey();
                Integer mapValue = (int) entry.getValue();
                if (remainingAmount % mapKey == 0 && remainingAmount > 0) {
                    int bankNotesNeeded = neededBankNotes.containsKey(mapKey) ? neededBankNotes.get(mapKey) : 0;
                    if (this.getBankNotesMap().get(mapKey) - bankNotesNeeded > 0 && remainingAmount <= mapKey * mapValue) {
                        neededBankNotes.put(mapKey, bankNotesNeeded + 1);
                        remainingAmount -= mapKey;
                        returnValue = true;
                    }
                }
            }
        }

        if (returnValue) {
            for (Map.Entry entry : neededBankNotes.entrySet()) {
                Integer mapKey = (int) entry.getKey();
                Integer mapValue = (int) entry.getValue();
                bankNotesMap.put(mapKey, this.getBankNotesMap().get(mapKey) - mapValue);
            }
        }

        return returnValue;
    }

}
