package com.example.design.lld.ecommerce;

import java.util.Arrays;

public class EcommerceSite {
    public static void main(String[] args) {
        // Create Categories
        Category electronics = new Category(1, "Electronics", "Gadgets and devices");
        Category clothing = new Category(2, "Clothing", "Men's and Women's Apparel");

        // Create Products
        Product phone = new Product(1, "Smartphone", "A high-end smartphone", 10000, 50, electronics);
        Product tshirt = new Product(2, "T-Shirt", "A comfortable cotton t-shirt", 500, 100, clothing);

        // Create Customer
        Customer customer = new Customer(1, "Sukrit Raj", "password123", "sukritraj3@gmail.com");

        // Add items to the cart
        customer.getCart().addItem(phone, 1);
        customer.getCart().addItem(tshirt, 2);

        // Print Cart Items
        System.out.println("Cart Items:");
        customer.getCart().getCartItems().forEach(item -> System.out.println(item));

        // Calculate Cart Total
        double totalCartPrice = customer.getCart().calculateTotalPrice();
        System.out.println("Total Cart Price: $" + totalCartPrice);

        // Create Order
        ShippingInfo shippingInfo = new ShippingInfo("R-802", "Noida", "201301", "INDIA");
        Order order = new Order(1, customer, Arrays.asList(
                new OrderItem(phone, 1),
                new OrderItem(tshirt, 2)
        ), shippingInfo);

        // Process Payment
        Payment payment = new Payment(1, order);
        payment.makePayment();

        // Print Order Details
        System.out.println(order);
        System.out.println("Shipping Address: " + shippingInfo.getFullAddress());

        // Add Order to Customer's Order History
        customer.addOrder(order);
        System.out.println("Order History: " + customer.getOrderHistory());
    }

}
