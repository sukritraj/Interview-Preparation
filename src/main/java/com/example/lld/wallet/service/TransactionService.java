package com.example.lld.wallet.service;

import com.example.lld.wallet.model.Transaction;
import com.example.lld.wallet.model.User;
import com.example.lld.wallet.repository.TransactionRepository;
import com.example.lld.wallet.strategy.CashbackStrategy;

public class TransactionService {
    private final TransactionRepository transactionRepository = new TransactionRepository();
    private final WalletService walletService = new WalletService();

    public void transferMoney(User sender, User receiver, double amount, CashbackStrategy cashbackStrategy) {
        walletService.deductMoney(sender, amount);
        double cashback = cashbackStrategy.calculateCashback(amount);
        walletService.addMoney(receiver, amount);
        walletService.addMoney(sender, cashback);

        Transaction transaction = new Transaction(sender.getId(), receiver.getId(), amount, cashback);
        transactionRepository.save(transaction);
    }

    public void printAllTransactions() {
        for (Transaction tx : transactionRepository.getAll()) {
            System.out.println(tx);
        }
    }
}
