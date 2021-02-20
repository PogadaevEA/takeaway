package com.home.takeaway.application.controller;

import com.home.takeaway.application.dto.RestaurantDTO;
import com.home.takeaway.common.utils.UserUtils;
import com.home.takeaway.domain.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<List<RestaurantDTO>> getAllForCurrentUser() {
       return ResponseEntity.ok().body(restaurantService.getRestaurantListByUserId(UserUtils.getCurrentUserId()));
    }

    @ApiOperation(value = "Create new restaurant", response = RestaurantDTO.class)
    @PreAuthorize("havePermission('RESTAURANT_CREATE')")
    @PutMapping
    public ResponseEntity<RestaurantDTO> create(@RequestBody RestaurantDTO restaurantDTO) {
        return ResponseEntity.ok().body(restaurantService.createRestaurant(restaurantDTO));
    }
}