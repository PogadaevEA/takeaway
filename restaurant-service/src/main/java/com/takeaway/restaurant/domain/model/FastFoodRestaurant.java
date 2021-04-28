package com.takeaway.restaurant.domain.model;


public class FastFoodRestaurant extends Restaurant {

    @Override
    public RestaurantType getRestaurantType() {
        return RestaurantType.FASTFOOD;
    }
}
