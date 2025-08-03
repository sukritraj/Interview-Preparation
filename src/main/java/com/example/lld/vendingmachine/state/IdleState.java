package com.example.lld.vendingmachine.state;

import com.example.lld.vendingmachine.core.VendingMachine;

public class IdleState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vm, int amount) {
        vm.getPaymentProcessor().addMoney(amount);
        vm.getCoinRepository().addCoins(amount, 1);
        System.out.println("Inserted ₹" + amount + ". Balance: ₹" + vm.getPaymentProcessor().getBalance());
        vm.setState(new HasMoneyState());
    }

    @Override
    public void selectItem(VendingMachine vm, String code) {
        System.out.println("Insert money first.");
    }

    @Override
    public void dispenseItem(VendingMachine vm) {
        System.out.println("Insert money first.");
    }

    @Override
    public void refund(VendingMachine vm) {
        System.out.println("No money to refund.");
    }
}
