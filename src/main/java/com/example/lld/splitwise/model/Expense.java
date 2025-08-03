package com.example.lld.splitwise.model;

import java.util.List;

public class Expense {
    private final double amount;
    private final User paidBy;
    private final List<Split> splits;
    private final String description;

    public Expense(double amount, User paidBy, List<Split> splits, String description) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.description = description;
    }

    public double getAmount() { return amount; }

    public User getPaidBy() { return paidBy; }

    public List<Split> getSplits() { return splits; }

    public String getDescription() { return description; }
}
