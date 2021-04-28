package com.takeaway.restaurant.domain.factory.restaurant;

import com.takeaway.restaurant.domain.model.CoffeeRestaurant;
import com.takeaway.restaurant.domain.model.Restaurant;
import com.takeaway.restaurant.domain.model.RestaurantType;
import org.springframework.stereotype.Component;

@Component
public class CoffeeRestaurantFactory implements RestaurantFactory {

    @Override
    public Restaurant create() {
        return new CoffeeRestaurant();
    }

    @Override
    public String getType() {
        return RestaurantType.COFFEE.name();
    }
}