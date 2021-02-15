package com.home.takeaway.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FASTFOOD")
public class FastFoodRestaurant extends Restaurant {

    @Override
    public RestaurantType getRestaurantType() {
        return RestaurantType.FASTFOOD;
    }
}
