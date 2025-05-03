package com.example.design.lld.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private Cart cart;
    private List<Order> orderHistory;

    public Customer(int userId, String username, String password, String email) {
        super(userId, username, password, email);
        this.cart = new Cart();
        this.orderHistory = new ArrayList<>();
    }

    @Override
    public void viewProfile() {
        System.out.println("Customer Profile: " + getUsername());
    }

    public Cart getCart() {
        return cart;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }
}

