package com.example.lld.zomato;

import com.example.lld.zomato.deliveryPartnerManagement.DeliveryService;
import com.example.lld.zomato.notificationManagement.NotificationService;
import com.example.lld.zomato.orderManagement.Order;
import com.example.lld.zomato.restaurantManagement.MenuItem;
import com.example.lld.zomato.restaurantManagement.Restaurant;
import com.example.lld.zomato.userManagement.Customer;
import com.example.lld.zomato.userManagement.DeliveryPartner;

import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryApp {
    public static void main(String[] args) {
        // Create Customer
        Customer customer = new Customer();

        // Create Restaurant & Menu
        Restaurant restaurant = new Restaurant("R001", "Tasty Bites", "Street 123");
        MenuItem pizza = new MenuItem("M001", "Pizza", 500, 20);
        MenuItem burger = new MenuItem("M002", "Burger", 250, 10);
        restaurant.addMenuItem(pizza);
        restaurant.addMenuItem(burger);

        // Place Order with Payment Type
        Order order = new Order("O001", customer, restaurant, List.of(pizza, burger), "UPI");

        // Process Payment
        boolean paymentSuccess = order.completePayment();

        if (paymentSuccess) {
            System.out.println("Payment Successful for Order ID: " + order.orderId);
        } else {
            System.out.println("Payment Failed for Order ID: " + order.orderId);
        }

        if (paymentSuccess) {
            List<DeliveryPartner> availablePartners = new ArrayList<>();
            availablePartners.add(new DeliveryPartner("D001", "Rahul", "rahul@gmail.com", "9876543210", "Test", "BR-27", true));

            DeliveryService deliveryService = new DeliveryService();
            DeliveryPartner assignedPartner = deliveryService.assignDeliveryPartner(order, availablePartners);

            if (assignedPartner != null) {
                System.out.println("Delivery assigned to: " + assignedPartner.name);
            } else {
                System.out.println("No delivery partner available.");
            }
        }

        // Send Notification
        NotificationService notificationService = NotificationService.getInstance();
    }
}


