package com.example.lld.restaurantManagement.service;

import com.example.lld.restaurantManagement.model.*;
import com.example.lld.restaurantManagement.repository.*;

import java.util.*;
import java.util.stream.Collectors;

public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final OrderRepository orderRepository;
    private final ReviewRepository reviewRepository;
    private final UserService userService;

    public RestaurantService(RestaurantRepository restaurantRepository,
                             OrderRepository orderRepository,
                             ReviewRepository reviewRepository,
                             UserService userService) {
        this.restaurantRepository = restaurantRepository;
        this.orderRepository = orderRepository;
        this.reviewRepository = reviewRepository;
        this.userService = userService;
    }

    public void registerRestaurant(String name, List<Integer> pincodes, Food food, int quantity) {
        if (restaurantRepository.exists(name)) {
            System.out.println("Restaurant already exists");
            return;
        }
        Restaurant restaurant = new Restaurant(name, pincodes, food,quantity);
        restaurantRepository.save(restaurant);
        System.out.println("Restaurant registered: " + name);
    }

    public void updateQuantity(String restaurantName, int quantityToAdd) {
        Restaurant restaurant = restaurantRepository.getByName(restaurantName);
        if (restaurant == null) {
            System.out.println("Restaurant not found");
            return;
        }
        restaurant.addQuantity(quantityToAdd);
        System.out.println("Updated quantity for: " + restaurantName);
    }

    public void showRestaurants(String sortBy) {
        User user = userService.getCurrentUser();
        if (user == null) {
            System.out.println("Please login first.");
            return;
        }

        /*List<Restaurant> serviceable = restaurantRepository.getAll().stream()
                .filter(r -> r.getServiceablePinCodes().contains(Integer.valueOf(user.getLocation())))
                .collect(Collectors.toList());*/

       /* if ("price".equalsIgnoreCase(sortBy)) {
            serviceable.sort(Comparator.comparingDouble(r -> g));
        } else if ("rating".equalsIgnoreCase(sortBy)) {
            serviceable.sort((a, b) -> Double.compare(b.getRating(), a.getRating()));
        }

        for (Restaurant r : serviceable) {
            Food food = r.getMenu().get(0);
            System.out.println(r.getName() + ", " + food.getName() + " - ₹" + food.getPrice());
        }*/
    }

    public void placeOrder(String restaurantName, int quantity) {
/*        User user = userService.getCurrentUser();
        Restaurant restaurant = restaurantRepository.getByName(restaurantName);

        if (restaurant == null || user == null) {
            System.out.println("Invalid restaurant or user.");
            return;
        }

        if (!restaurant.getServiceablePinCodes().contains(Integer.valueOf(user.getLocation()))) {
            System.out.println("Restaurant not serviceable at your location.");
            return;
        }

        Food food = restaurant.getMenu().get(0);
        if (food.getQuantity() < quantity) {
            System.out.println("Insufficient quantity.");
            return;
        }

        food.reduceQuantity(quantity);
        double totalPrice = food.getPrice() * quantity;
        Order order = new Order(UUID.randomUUID().toString(), restaurantName, user.getName(), food.getName(), totalPrice, "PLACED");
        orderRepository.saveOrder(order);
        System.out.println("Order Placed Successfully.");*/
    }

    public void orderHistory() {
        User user = userService.getCurrentUser();
        if (user == null) {
            System.out.println("Please login first.");
            return;
        }

        List<Order> orders = orderRepository.getOrdersByUser(user.getName());
        for (Order order : orders) {
            System.out.println(order.getOrderId() + ": " + order.getFoodName() + " from " + order.getRestaurantName() + " - ₹" + order.getPrice());
        }
    }

    public void createReview(String restaurantName, int rating, String comment) {
        User user = userService.getCurrentUser();
        if (user == null) {
            System.out.println("Please login first.");
            return;
        }

        Review review = new Review(user.getName(), restaurantName, comment, rating);
        reviewRepository.save(review);
    //    restaurantRepository.updateRating(restaurantName, reviewRepository.getAverageRating(restaurantName));
        System.out.println("Review submitted.");
    }
}
