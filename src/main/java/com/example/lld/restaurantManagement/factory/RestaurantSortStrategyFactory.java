package com.example.lld.restaurantManagement.factory;

import com.example.lld.restaurantManagement.strategy.DefaultSortStrategy;
import com.example.lld.restaurantManagement.strategy.PriceSortStrategy;
import com.example.lld.restaurantManagement.strategy.RatingSortStrategy;
import com.example.lld.restaurantManagement.strategy.RestaurantSortStrategy;

public class RestaurantSortStrategyFactory {

    public static RestaurantSortStrategy getSortStrategy(String sortType) {
        switch (sortType) {
            case "RATING":
                return new RatingSortStrategy();
            case "PRICE":
                return new PriceSortStrategy();
            default:
                return new DefaultSortStrategy();
        }
    }
}
