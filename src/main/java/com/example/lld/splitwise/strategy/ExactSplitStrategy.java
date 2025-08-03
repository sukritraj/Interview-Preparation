package com.example.lld.splitwise.strategy;

import com.example.lld.splitwise.model.Expense;
import com.example.lld.splitwise.model.Split;
import com.example.lld.splitwise.model.User;

import java.util.List;

public class ExactSplitStrategy implements SplitStrategy{
    @Override
    public Expense createExpense(double amount, User paidBy, List<Split> splits, String description) {
        double total = splits.stream().mapToDouble(Split::getAmount).sum();
        if (Math.abs(total - amount) > 0.01) {
            throw new IllegalArgumentException("Exact splits do not sum to total.");
        }
        return new Expense(amount, paidBy, splits, description);
    }
}
