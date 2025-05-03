package com.example.design.lld.ecommerce;

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double calculatePrice() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return product.getName() + " x " + quantity;
    }
}

