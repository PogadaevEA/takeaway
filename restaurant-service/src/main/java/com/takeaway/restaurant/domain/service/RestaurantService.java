package com.takeaway.restaurant.domain.service;

import com.takeaway.restaurant.application.dto.RestaurantDTO;
import com.takeaway.restaurant.domain.factory.restaurant.RestaurantFactory;
import com.takeaway.restaurant.domain.mapper.RestaurantMapper;
import com.takeaway.restaurant.domain.repository.RestaurantRepository;
import com.takeaway.restaurant.domain.model.Restaurant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RestaurantService {

    private final Map<String, RestaurantFactory> restaurantFactories;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Autowired
    RestaurantService(List<RestaurantFactory> restaurantFactories, RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantFactories = restaurantFactories.stream()
                .collect(Collectors.toMap(RestaurantFactory::getType, factory -> factory));
        this.restaurantMapper = restaurantMapper;
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

    @Transactional
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant =  restaurantFactories.get(restaurantDTO.getRestaurantType()).create();
        restaurantMapper.mapToEntity(restaurant, restaurantDTO);

        restaurantRepository.save(restaurant);
        Long restaurantId = restaurantRepository.getLastId();
        return restaurantMapper.mapToDto(restaurantRepository.findOne(restaurantId), new RestaurantDTO());
    }
}