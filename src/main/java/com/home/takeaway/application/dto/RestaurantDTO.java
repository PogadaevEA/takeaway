package com.home.takeaway.application.dto;

import com.home.takeaway.domain.model.Restaurant;
import lombok.Data;

import java.util.Date;

@Data
public class RestaurantDTO {

    private String name;
    private String address;
    private String contactPerson;
    private String contactPhone;
    private Double lat;
    private Double lon;
    private String workTime;
    private Date created;
    private String restaurantType;

    public RestaurantDTO(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.address = restaurant.getAddress();
        this.contactPerson = restaurant.getContactPerson();
        this.contactPhone = restaurant.getContactPhone();
        this.lat = restaurant.getLat();
        this.lon = restaurant.getLon();
        this.workTime = restaurant.getWorkTime();
        this.created = restaurant.getCreated();
        this.restaurantType = restaurant.getRestaurantType().name();
    }
}
