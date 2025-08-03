package com.example.lld.splitwise.strategy;

import com.example.lld.splitwise.model.Expense;
import com.example.lld.splitwise.model.Split;
import com.example.lld.splitwise.model.User;

import java.util.List;

public interface SplitStrategy {
    Expense createExpense(double amount, User paidBy, List<Split> splits, String description);
}
