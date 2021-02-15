package com.home.takeaway.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "COFFEE")
public class CoffeeRestaurant extends Restaurant {

    @Override
    public RestaurantType getRestaurantType() {
        return RestaurantType.COFFEE;
    }
}
