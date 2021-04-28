package com.takeaway.restaurant.domain.factory.restaurant;

import com.takeaway.restaurant.domain.model.Restaurant;

public interface RestaurantFactory {
    <T extends Restaurant> T create();
    String getType();
}