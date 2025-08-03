package com.example.lld.restaurantManagement.repository;

import com.example.lld.restaurantManagement.model.Order;

import java.util.*;

public class OrderRepository {
    private final Map<String, List<Order>> ordersByUser = new HashMap<>();

    public void save(Order order) {
        ordersByUser
                .computeIfAbsent(order.getUserName(), k -> new ArrayList<>())
                .add(order);
    }

    public List<Order> getOrdersByUser(String username) {
        return ordersByUser.getOrDefault(username, Collections.emptyList());
    }

    public List<Order> getAllOrders() {
        return ordersByUser.values()
                .stream()
                .flatMap(List::stream)
                .toList();
    }
}
