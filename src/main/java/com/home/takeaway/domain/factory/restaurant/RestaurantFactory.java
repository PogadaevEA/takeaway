package com.home.takeaway.domain.factory.restaurant;

import com.home.takeaway.domain.model.Restaurant;

public interface RestaurantFactory {
    <T extends Restaurant> T create();
    String getType();
}