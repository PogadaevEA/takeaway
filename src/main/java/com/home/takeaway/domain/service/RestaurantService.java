package com.home.takeaway.domain.service;

import com.home.takeaway.application.dto.RestaurantDTO;
import com.home.takeaway.domain.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantDTO> getRestaurantList() {
        List<RestaurantDTO> list = new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurant -> list.add(new RestaurantDTO(restaurant)));
        return list;
    }
}