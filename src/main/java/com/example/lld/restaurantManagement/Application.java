package com.example.lld.restaurantManagement;

import com.example.lld.restaurantManagement.model.Food;
import com.example.lld.restaurantManagement.repository.OrderRepository;
import com.example.lld.restaurantManagement.repository.RestaurantRepository;
import com.example.lld.restaurantManagement.repository.ReviewRepository;
import com.example.lld.restaurantManagement.repository.UserRepository;
import com.example.lld.restaurantManagement.service.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Init repositories
        UserRepository userRepo = new UserRepository();
        RestaurantRepository restRepo = new RestaurantRepository();
        OrderRepository orderRepo = new OrderRepository();
        ReviewRepository reviewRepo = new ReviewRepository();

        // Init services
        UserService userService = new UserService(userRepo);
        RestaurantService restaurantService = new RestaurantService(restRepo,orderRepo,  reviewRepo,userService);
        OrderService orderService = new OrderService(orderRepo, restRepo, userRepo);
        DiscoveryService discoveryService = new DiscoveryService(restRepo);
        ReviewService reviewService = new ReviewService(restRepo, reviewRepo);

        // Sample flow (you can replicate commands from your flow)
        userService.registerUser("Pralove", "M", "phone-1", "560102");
        userService.registerUser("Nitesh", "M", "phone-2", "560103");

        restaurantService.registerRestaurant("Food Court-1", List.of(560102, 560103),
                new Food("NI Thali", "VEG", 100), 5);

        restaurantService.registerRestaurant("Food Court-2", List.of(560103),
                new Food("Burger", "NON-VEG", 120), 3);

        orderService.placeOrder("Pralove", "Food Court-1", 2);
        reviewService.createReview("Pralove", "Food Court-1", 5, "Excellent");
        discoveryService.showRestaurants("rating");
    }
}
