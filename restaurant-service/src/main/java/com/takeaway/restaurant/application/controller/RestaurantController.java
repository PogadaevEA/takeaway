package com.takeaway.restaurant.application.controller;

import com.takeaway.restaurant.application.dto.RestaurantDTO;
import com.takeaway.restaurant.domain.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Restaurant Controller", produces = "application/json")
@RestController
@RequestMapping(path = "/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @ApiOperation(value = "Getting all restaurant list", response = RestaurantDTO.class, responseContainer = "List")
    @GetMapping(value = "/list/all")
    public ResponseEntity<List<RestaurantDTO>> getAll() {
        return ResponseEntity.ok().body(restaurantService.getRestaurantList());
    }

    @ApiOperation(value = "Getting all restaurant list for current user", response = RestaurantDTO.class, responseContainer = "List")
    @GetMapping(value = "/list")
    public ResponseEntity<List<RestaurantDTO>> getAllForCurrentUser(@RequestParam String userId) {
       return ResponseEntity.ok().body(restaurantService.getRestaurantListByUserId(userId));
    }

    @ApiOperation(value = "Create new restaurant", response = RestaurantDTO.class)
    @PutMapping
    public ResponseEntity<RestaurantDTO> create(@RequestBody RestaurantDTO restaurantDTO) {
        return ResponseEntity.ok().body(restaurantService.createRestaurant(restaurantDTO));
    }
}