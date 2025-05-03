package com.example.design.lld.ecommerce;

import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<OrderItem> orderItems;
    private ShippingInfo shippingInfo;
    private OrderStatus status;

    public Order(int orderId, Customer customer, List<OrderItem> orderItems, ShippingInfo shippingInfo) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderItems = orderItems;
        this.shippingInfo = shippingInfo;
        this.status = OrderStatus.PENDING;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double calculateTotal() {
        return orderItems.stream().mapToDouble(OrderItem::calculatePrice).sum();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Total: $" + calculateTotal() + ", Status: " + status;
    }
}

