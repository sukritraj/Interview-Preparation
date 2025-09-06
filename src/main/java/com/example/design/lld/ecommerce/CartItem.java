package com.example.design.lld.ecommerce;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    @Override
    public String toString() {
        return "Product: " + product.getName() + ", Quantity: " + quantity;
    }
}

