package com.example.lld.zomato.orderManagement;

import com.example.lld.zomato.paymentManagement.Payment;
import com.example.lld.zomato.paymentManagement.PaymentStatus;
import com.example.lld.zomato.restaurantManagement.MenuItem;
import com.example.lld.zomato.restaurantManagement.Restaurant;
import com.example.lld.zomato.userManagement.Customer;

import java.util.List;

public class Order {
    public String orderId;
    public Customer customer;
    public Restaurant restaurant;
    public List<MenuItem> items;
    public double totalAmount;
    public Payment payment;
    public OrderStatus status;

    public Order(String orderId, Customer customer, Restaurant restaurant, List<MenuItem> items, String paymentType) {
        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = items;
        this.totalAmount = calculateTotal();
        this.status = OrderStatus.PLACED;
        this.payment = new Payment("P" + orderId, totalAmount, paymentType);
    }

    private double calculateTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public boolean completePayment() {
        boolean success = payment.processPayment();
        if (success) {
            this.status = OrderStatus.CONFIRMED; // ✅ FIXED: Update Order Status
        }
        return success;
    }

    public PaymentStatus getPaymentStatus() {
        return payment.getStatus();
    }

    public OrderStatus getOrderStatus() {
        return status;
    }
}
