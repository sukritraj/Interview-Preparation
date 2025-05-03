package com.example.design.lld.ecommerce;

public class Product {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int quantityAvailable;
    private Category category;

    public Product(int productId, String name, String description, double price, int quantityAvailable, Category category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void reduceQuantity(int amount) {
        if (amount <= quantityAvailable) {
            this.quantityAvailable -= amount;
        }
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + name + ", Price: " + price + ", Available Quantity: " + quantityAvailable;
    }
}
