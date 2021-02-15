package com.home.takeaway.domain.service;

import com.home.takeaway.application.dto.RestaurantDTO;
import com.home.takeaway.domain.factory.restaurant.RestaurantFactory;
import com.home.takeaway.domain.mapper.RestaurantMapper;
import com.home.takeaway.domain.model.Restaurant;
import com.home.takeaway.domain.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@Service
public class RestaurantService {

    private final Map<String, RestaurantFactory> restaurantFactories;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper mapper;

    @Autowired
    RestaurantService(List<RestaurantFactory> restaurantFactories, RestaurantRepository restaurantRepository, RestaurantMapper mapper) {
        this.restaurantRepository = restaurantRepository;
        this.mapper = mapper;
        this.restaurantFactories = restaurantFactories.stream()
                .collect(Collectors.toMap(RestaurantFactory::getType, factory -> factory));
    }

    public List<RestaurantDTO> getRestaurantList() {
        return restaurantRepository.findAll()
                .stream()
                .map(RestaurantDTO::new)
                .collect(Collectors.toList());
    }

    public List<RestaurantDTO> getRestaurantListByUserId(String userId) {
        return restaurantRepository.findAllByUserId(userId).stream()
                .map(RestaurantDTO::new)
                .collect(Collectors.toList());

    }

    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant =  restaurantFactories.get(restaurantDTO.getRestaurantType()).create();
        mapper.mapToEntity(restaurant, restaurantDTO);

        return mapper.mapToDto(restaurantRepository.save(restaurant), new RestaurantDTO());
    }
}