package com.home.takeaway.application.controllers;

import com.home.takeaway.application.dto.RestaurantDTO;
import com.home.takeaway.application.managers.RestaurantManager;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j
@RestController
public class RestaurantController {

    private final RestaurantManager restaurantManager;

    @Autowired
    public RestaurantController(
        RestaurantManager restaurantManager
    ) {
        this.restaurantManager = restaurantManager;
    }

    /**
     * Получить список ресторанов
     */
    @PostMapping("/restaurant/list")
    public ResponseEntity getRestaurantList() {
        List<RestaurantDTO> restaurantDTOList = restaurantManager.getRestaurantList();
        return ResponseEntity.ok().body(restaurantDTOList);
    }
}
