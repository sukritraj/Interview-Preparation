package com.example.lld.wallet.model;

public class User {
    private final String id;
    private final String name;
    private Wallet wallet;
    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.wallet = new Wallet(id);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Wallet getWallet() { return wallet; }
}
