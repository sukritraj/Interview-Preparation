package com.example.lld.splitwise;

import com.example.lld.splitwise.model.*;
import com.example.lld.splitwise.repository.UserRepository;
import com.example.lld.splitwise.service.ExpenseService;

import java.util.List;

public class SplitwiseApp {
    public static void main(String[] args) {
        UserRepository userRepo = new UserRepository();

        User u1 = new User("u1", "Aman","6205264819");
        User u2 = new User("u2", "Sukrit","9546275163");
        User u3 = new User("u3", "Ravi","8541082866");

        userRepo.save(u1);
        userRepo.save(u2);
        userRepo.save(u3);

        ExpenseService expenseService = new ExpenseService();

        List<Split> splits = List.of(new EqualSplit(u1), new EqualSplit(u2), new EqualSplit(u3));
        expenseService.addExpense(SplitType.EQUAL, 900, u1, splits, "Dinner");

        expenseService.showBalances();
        System.out.println("Balances Before Settlement:");
        expenseService.showBalances();

        // Settle Sukrit's balance with Aman
        expenseService.settleUp("u2", "u1");

        System.out.println("\nBalances After Settlement:");
        expenseService.showBalances();

        List<Split> percentageSplits = List.of(
                new PercentageSplit(u1, 40.0),
                new PercentageSplit(u2, 30.0),
                new PercentageSplit(u3, 30.0)
        );

        expenseService.addExpense(SplitType.PERCENTAGE, 1000, u1, percentageSplits, "Movie + Snacks");

        expenseService.showBalances();

        List<Split> exactSplits = List.of(
                new ExactSplit(u1, 500),
                new ExactSplit(u2, 400),
                new ExactSplit(u3, 300)
        );

        expenseService.addExpense(SplitType.EXACT, 1200, u3, exactSplits, "Weekend Trip");

        expenseService.showBalances();


    }
}
