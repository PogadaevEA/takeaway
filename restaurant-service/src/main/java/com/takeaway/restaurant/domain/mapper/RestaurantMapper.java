package com.takeaway.restaurant.domain.mapper;

import com.takeaway.restaurant.application.dto.RestaurantDTO;
import com.takeaway.restaurant.domain.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RestaurantMapper implements com.takeaway.restaurant.domain.mapper.Mapper<Restaurant, RestaurantDTO> {

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
