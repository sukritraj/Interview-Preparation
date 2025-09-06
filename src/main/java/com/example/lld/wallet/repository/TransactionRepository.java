package com.example.lld.wallet.repository;

import com.example.lld.wallet.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getAll() {
        return transactions;
    }
}
