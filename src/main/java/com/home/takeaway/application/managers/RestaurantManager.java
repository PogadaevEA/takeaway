package com.home.takeaway.application.managers;

import com.home.takeaway.application.dto.RestaurantDTO;
import com.home.takeaway.domain.model.Restaurant;
import com.home.takeaway.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantManager {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantManager(
            RestaurantRepository restaurantRepository
    ) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<RestaurantDTO> getRestaurantList() {
        List<RestaurantDTO> list = new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurant -> list.add(new RestaurantDTO(restaurant)));
        return list;
    }
}
