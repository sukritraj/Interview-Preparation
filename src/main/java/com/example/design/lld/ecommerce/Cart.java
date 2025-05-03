package com.example.design.lld.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getProductId() == product.getProductId()) {
                item.increaseQuantity(quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public void removeItem(Product product) {
        cartItems.removeIf(item -> item.getProduct().getProductId() == product.getProductId());
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}

