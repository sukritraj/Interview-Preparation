package com.example.lld.vendingmachine;

import com.example.lld.vendingmachine.core.VendingMachine;
import com.example.lld.vendingmachine.model.Item;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        // Add items
        Item chips = new Item("A1", "Chips", 20);
        Item soda = new Item("B1", "Soda", 35);
        vm.getInventory().addStock(chips, 5);
        vm.getInventory().addStock(soda, 3);

        // Add coins
        vm.getCoinRepository().addCoins(1, 10);
        vm.getCoinRepository().addCoins(2, 10);
        vm.getCoinRepository().addCoins(5, 5);
        vm.getCoinRepository().addCoins(10, 2);

        vm.displayItems();

        vm.insertCoin(20);
        vm.insertCoin(10);
        vm.selectItem("B1");

        // Try refund
        vm.refund();
    }
}

