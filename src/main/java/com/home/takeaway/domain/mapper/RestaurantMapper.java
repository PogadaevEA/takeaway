package com.home.takeaway.domain.mapper;

import com.home.takeaway.application.dto.RestaurantDTO;
import com.home.takeaway.domain.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RestaurantMapper implements Mapper<Restaurant, RestaurantDTO> {

    @Override
    public Restaurant mapToEntity(Restaurant restaurant, RestaurantDTO restaurantDTO) {
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setName(restaurantDTO.getName());
        restaurant.setCreated(new Date());

        return restaurant;
    }

    @Override
    public RestaurantDTO mapToDto(Restaurant value, RestaurantDTO restaurantDTO) {
        return RestaurantDTO.builder()
                .name(value.getName())
                .address(value.getAddress())
                .created(value.getCreated())
                .build();
    }
}
