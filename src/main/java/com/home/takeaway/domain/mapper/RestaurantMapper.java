package com.home.takeaway.domain.mapper;

import com.home.takeaway.application.dto.RestaurantDTO;
import com.home.takeaway.domain.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper implements Mapper<Restaurant, RestaurantDTO> {

    @Override
    public Restaurant mapToEntity(Restaurant restaurant, RestaurantDTO restaurantDTO) {
        return null;
    }

    @Override
    public RestaurantDTO mapToDto(Restaurant value, RestaurantDTO restaurantDTO) {
        return null;
    }
}
