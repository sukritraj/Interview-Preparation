package com.example.lld.vendingmachine.core;

import com.example.lld.vendingmachine.model.Item;
import com.example.lld.vendingmachine.repository.*;
import com.example.lld.vendingmachine.state.*;

public class VendingMachine {
    private VendingMachineState state;
    private final InventoryRepository inventory;
    private final CoinRepository coinRepository;
    private final PaymentProcessor paymentProcessor;
    private Item selectedItem;

    public VendingMachine() {
        this.state = new IdleState();
        this.inventory = new InventoryRepository();
        this.coinRepository = new CoinRepository();
        this.paymentProcessor = new PaymentProcessor();
    }

    public void insertCoin(int amount) { state.insertCoin(this, amount); }
    public void selectItem(String code) { state.selectItem(this, code); }
    public void dispenseItem() { state.dispenseItem(this); }
    public void refund() { state.refund(this); }
    public void displayItems() { inventory.displayItems(); }

    public void setState(VendingMachineState state) { this.state = state; }
    public InventoryRepository getInventory() { return inventory; }
    public CoinRepository getCoinRepository() { return coinRepository; }
    public PaymentProcessor getPaymentProcessor() { return paymentProcessor; }

    public Item getSelectedItem() { return selectedItem; }
    public void setSelectedItem(Item item) { this.selectedItem = item; }
}
