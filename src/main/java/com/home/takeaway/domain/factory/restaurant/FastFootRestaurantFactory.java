package com.home.takeaway.domain.factory.restaurant;

import com.home.takeaway.domain.model.FastFoodRestaurant;
import com.home.takeaway.domain.model.Restaurant;
import com.home.takeaway.domain.model.RestaurantType;
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