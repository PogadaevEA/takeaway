package com.takeaway.restaurant.domain.factory.restaurant;

import com.takeaway.restaurant.domain.model.FastFoodRestaurant;
import com.takeaway.restaurant.domain.model.Restaurant;
import com.takeaway.restaurant.domain.model.RestaurantType;
import org.springframework.stereotype.Component;

@Component
public class FastFootRestaurantFactory implements RestaurantFactory {

    @Override
    public Restaurant create() {
        return new FastFoodRestaurant();
    }

    @Override
    public String getType() {
        return RestaurantType.FASTFOOD.name();
    }
}