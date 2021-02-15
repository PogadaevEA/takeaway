package com.home.takeaway.application.dto;

import com.home.takeaway.domain.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {

    private String name;
    private String address;
    private String contactPerson;
    private String ownerPerson;
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
        this.ownerPerson = restaurant.getUser().getFIO();
        this.contactPhone = restaurant.getContactPhone();
        this.lat = restaurant.getLat();
        this.lon = restaurant.getLon();
        this.workTime = restaurant.getWorkTime();
        this.created = restaurant.getCreated();
        this.restaurantType = restaurant.getRestaurantType().name();
    }


}
