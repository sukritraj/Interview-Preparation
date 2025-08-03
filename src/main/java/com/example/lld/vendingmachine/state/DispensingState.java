package com.example.lld.vendingmachine.state;

import com.example.lld.vendingmachine.core.VendingMachine;
import com.example.lld.vendingmachine.model.Item;

public class DispensingState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vm, int amount) {
        System.out.println("Dispensing in progress. Cannot accept coins.");
    }

    @Override
    public void selectItem(VendingMachine vm, String code) {
        System.out.println("Dispensing in progress.");
    }

    @Override
    public void dispenseItem(VendingMachine vm) {
        Item item = vm.getSelectedItem();
        if (item == null) {
            System.out.println("No item selected.");
            return;
        }

        vm.getInventory().reduceStock(item);
        System.out.println("Dispensing: " + item.getName());

        int balance = vm.getPaymentProcessor().getBalance();
        int change = balance - item.getPrice();

        try {
            if (change > 0) {
                var coins = vm.getCoinRepository().getChange(change);
                System.out.println("Returning change: ₹" + change + " as coins: " + coins);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        vm.getPaymentProcessor().refund();
        vm.setSelectedItem(null);
        vm.setState(new IdleState());
    }

    @Override
    public void refund(VendingMachine vm) {
        System.out.println("Cannot refund during dispensing.");
    }
}

