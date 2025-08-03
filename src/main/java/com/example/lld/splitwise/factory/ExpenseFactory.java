package com.example.lld.splitwise.factory;

import com.example.lld.splitwise.model.Expense;
import com.example.lld.splitwise.model.Split;
import com.example.lld.splitwise.model.SplitType;
import com.example.lld.splitwise.model.User;
import com.example.lld.splitwise.strategy.EqualSplitStrategy;
import com.example.lld.splitwise.strategy.ExactSplitStrategy;
import com.example.lld.splitwise.strategy.PercentageSplitStrategy;
import com.example.lld.splitwise.strategy.SplitStrategy;

import java.util.List;

public class ExpenseFactory {
    public static Expense createExpense(SplitType type, double amount, User paidBy, List<Split> splits, String description) {
        SplitStrategy strategy = switch (type) {
            case EQUAL -> new EqualSplitStrategy();
            case EXACT -> new ExactSplitStrategy();
            case PERCENTAGE -> new PercentageSplitStrategy();
        };

        return strategy.createExpense(amount, paidBy, splits, description);
    }
}
