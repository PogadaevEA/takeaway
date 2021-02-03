package com.home.takeaway.application.controllers;

import com.home.takeaway.application.dto.RestaurantDTO;
import com.home.takeaway.domain.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Restaurant Controller", produces = "application/json")
@RestController
@RequestMapping(path = "/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @ApiOperation(value = "Getting all restaurant list", response = RestaurantDTO.class, responseContainer = "List")
    @GetMapping(value = "/list")
    public ResponseEntity getAll() {
        List<RestaurantDTO> restaurantDTOList = restaurantService.getRestaurantList();
        return ResponseEntity.ok().body(restaurantDTOList);
    }
}