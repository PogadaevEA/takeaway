package com.takeaway.restaurant.domain.model;


public class CoffeeRestaurant extends Restaurant {

    @Override
    public RestaurantType getRestaurantType() {
        return RestaurantType.COFFEE;
    }
}
