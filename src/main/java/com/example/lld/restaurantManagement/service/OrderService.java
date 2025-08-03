package com.example.lld.restaurantManagement.service;

import com.example.lld.restaurantManagement.model.Order;
import com.example.lld.restaurantManagement.model.Restaurant;
import com.example.lld.restaurantManagement.model.User;
import com.example.lld.restaurantManagement.repository.OrderRepository;
import com.example.lld.restaurantManagement.repository.RestaurantRepository;
import com.example.lld.restaurantManagement.repository.UserRepository;

import java.util.List;
import java.util.UUID;

public class OrderService {
    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepo, RestaurantRepository restaurantRepo, UserRepository userRepo) {
        this.orderRepository = orderRepo;
        this.restaurantRepository = restaurantRepo;
        this.userRepository = userRepo;
    }

    public void placeOrder(String username, String restaurantName, int quantity) {
        User user = userRepository.getByName(username);
        Restaurant restaurant = restaurantRepository.getByName(restaurantName);

        if (restaurant == null || user == null) {
            System.out.println("Invalid user or restaurant.");
            return;
        }

        if (!restaurant.isServiceable(Integer.parseInt(user.getLocation()))) {
            System.out.println("Restaurant not serviceable to your location.");
            return;
        }

        if (restaurant.getQuantity() < quantity) {
            System.out.println("Cannot place order. Insufficient quantity.");
            return;
        }

        restaurant.reduceQuantity(quantity);
        Order order = new Order(UUID.randomUUID().toString(), restaurantName, username,
                restaurant.getFood().getName(),
                restaurant.getFood().getPrice() * quantity, "PLACED");

        orderRepository.save(order);
        System.out.println("Order Placed Successfully.");
    }

    public void showOrderHistory(String username) {
        List<Order> orders = orderRepository.getOrdersByUser(username);
        orders.forEach(o ->
                System.out.println(o.getOrderId() + ": " + o.getRestaurantName() + " - " + o.getFoodName() + " - ₹" + o.getPrice())
        );
    }
}
