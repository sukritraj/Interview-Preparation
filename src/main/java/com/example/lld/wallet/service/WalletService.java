package com.example.lld.wallet.service;

import com.example.lld.wallet.exception.InsufficientBalanceException;
import com.example.lld.wallet.model.User;

public class WalletService {
    public void addMoney(User user, double amount) {
        user.getWallet().addBalance(amount);
    }

    public void deductMoney(User user, double amount) {
        if (user.getWallet().getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance for user " + user.getId());
        }
        user.getWallet().deductBalance(amount);
    }

    public double getBalance(User user) {
        return user.getWallet().getBalance();
    }
}
