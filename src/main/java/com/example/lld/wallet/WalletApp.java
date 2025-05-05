package com.example.lld.wallet;

import com.example.lld.wallet.model.User;
import com.example.lld.wallet.service.TransactionService;
import com.example.lld.wallet.service.UserService;
import com.example.lld.wallet.service.WalletService;
import com.example.lld.wallet.strategy.CashbackStrategyFactory;

public class WalletApp {
    public static void main(String[] args) {
        UserService userService = new UserService();
        WalletService walletService = new WalletService();
        TransactionService transactionService = new TransactionService();

        // Register users
        userService.registerUser("u1", "Rohan");
        userService.registerUser("u2", "Nandini");

        User rohan = userService.getUser("u1");
        User nandini = userService.getUser("u2");

        // Add money to Rohan's wallet
        walletService.addMoney(rohan, 1000.0);

        // Transfer money from Rohan to Nandini with 10% cashback
        transactionService.transferMoney(rohan, nandini, 200.0, CashbackStrategyFactory.getStrategy("fixed"));

        // Print Balances
        System.out.println("Rohan Wallet Balance: " + walletService.getBalance(rohan));
        System.out.println("Nandini Wallet Balance: " + walletService.getBalance(nandini));

        // Print Transactions
        transactionService.printAllTransactions();
    }
}
