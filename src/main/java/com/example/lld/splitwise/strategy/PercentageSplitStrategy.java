package com.example.lld.splitwise.strategy;

import com.example.lld.splitwise.model.Expense;
import com.example.lld.splitwise.model.PercentageSplit;
import com.example.lld.splitwise.model.Split;
import com.example.lld.splitwise.model.User;

import java.util.List;

public class PercentageSplitStrategy implements SplitStrategy{
    @Override
    public Expense createExpense(double amount, User paidBy, List<Split> splits, String description) {
        double totalPercent = 0;
        for (Split s : splits) {
            PercentageSplit ps = (PercentageSplit) s;
            totalPercent += ps.getPercent();
            ps.setAmount((ps.getPercent() * amount) / 100.0);
        }

        if (Math.abs(totalPercent - 100.0) > 0.01) {
            throw new IllegalArgumentException("Percentage split does not sum to 100%");
        }

        return new Expense(amount, paidBy, splits, description);
    }
}
