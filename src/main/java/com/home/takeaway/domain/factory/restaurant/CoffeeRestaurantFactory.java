package com.home.takeaway.domain.factory.restaurant;

import com.home.takeaway.domain.model.CoffeeRestaurant;
import com.home.takeaway.domain.model.Restaurant;
import com.home.takeaway.domain.model.RestaurantType;
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