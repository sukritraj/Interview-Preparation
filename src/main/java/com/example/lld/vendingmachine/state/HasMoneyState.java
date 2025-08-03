package com.example.lld.vendingmachine.state;

import com.example.lld.vendingmachine.core.VendingMachine;
import com.example.lld.vendingmachine.model.Item;

public class HasMoneyState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vm, int amount) {
        vm.getPaymentProcessor().addMoney(amount);
        vm.getCoinRepository().addCoins(amount, 1);
        System.out.println("Inserted ₹" + amount + ". Balance: ₹" + vm.getPaymentProcessor().getBalance());
    }

    @Override
    public void selectItem(VendingMachine vm, String code) {
        Item item = vm.getInventory().getItem(code);
        if (item == null) {
            System.out.println("Invalid code.");
            return;
        }
        if (vm.getInventory().getQuantity(item) <= 0) {
            System.out.println("Out of stock: " + item.getName());
            return;
        }

        int balance = vm.getPaymentProcessor().getBalance();
        if (balance < item.getPrice()) {
            System.out.println("Insufficient funds. Insert ₹" + (item.getPrice() - balance) + " more.");
            return;
        }

        int changeNeeded = balance - item.getPrice();
        if (!vm.getCoinRepository().canProvideChange(changeNeeded)) {
            System.out.println("Cannot provide exact change for ₹" + changeNeeded + ". Use exact change or cancel.");
            return;
        }

        vm.setSelectedItem(item);
        vm.setState(new DispensingState());
        vm.dispenseItem();
    }

    @Override
    public void dispenseItem(VendingMachine vm) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void refund(VendingMachine vm) {
        int refund = vm.getPaymentProcessor().refund();
        System.out.println("Refunded ₹" + refund);
        vm.setState(new IdleState());
    }
}
