package com.example.lld.vendingmachine.state;


import com.example.lld.vendingmachine.core.VendingMachine;

public interface VendingMachineState {
    void insertCoin(VendingMachine vm, int amount);
    void selectItem(VendingMachine vm, String code);
    void dispenseItem(VendingMachine vm);
    void refund(VendingMachine vm);
}

