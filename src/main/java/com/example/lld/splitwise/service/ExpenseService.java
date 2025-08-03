package com.example.lld.splitwise.service;

import com.example.lld.splitwise.factory.ExpenseFactory;
import com.example.lld.splitwise.model.Expense;
import com.example.lld.splitwise.model.Split;
import com.example.lld.splitwise.model.SplitType;
import com.example.lld.splitwise.model.User;

import java.util.List;

public class ExpenseService {
    private final BalanceSheet balanceSheet = new BalanceSheet();

    public void addExpense(SplitType type, double amount, User paidBy, List<Split> splits, String description) {
        Expense expense = ExpenseFactory.createExpense(type, amount, paidBy, splits, description);
        for (Split s : expense.getSplits()) {
            if (!s.getUser().getId().equals(paidBy.getId())) {
                balanceSheet.update(s.getUser().getId(), paidBy.getId(), s.getAmount());
            }
        }
    }

    public void showBalances() {
        balanceSheet.printBalances();
    }

    public void settleUp(String fromUserId, String toUserId) {
        balanceSheet.settleUp(fromUserId, toUserId);
    }
}
