package com.home.takeaway.application.controllers;

import com.home.takeaway.application.dto.RestaurantDTO;
import com.home.takeaway.application.managers.RestaurantManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Api(value = "Restaurant Controller", produces = "application/json")
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
     * @return ResponseEntity
     */
    @ApiOperation(value = "Getting all restaurant list", response = RestaurantDTO.class, responseContainer = "List")
    @GetMapping(value = "/restaurant/list")
    public ResponseEntity getRestaurantList() {
        List<RestaurantDTO> restaurantDTOList = restaurantManager.getRestaurantList();
        return ResponseEntity.ok().body(restaurantDTOList);
    }
}
