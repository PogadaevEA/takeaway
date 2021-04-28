package com.takeaway.restaurant.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Ресторан - заведение общепита
 */
@Getter
@Setter
public abstract class Restaurant {

    private Long id;

    private String name;
    private String address;
    private String contactPerson;
    private String contactPhone;
    private Double lat;
    private Double lon;
    private String workTime;
    private Date created;

    public abstract RestaurantType getRestaurantType();
}