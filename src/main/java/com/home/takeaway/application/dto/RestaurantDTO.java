package com.home.takeaway.application.dto;

import com.home.takeaway.domain.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {

    /**
     * Название
     */
    @Getter @Setter private String name;

    /**
     * Адресс
     */
    @Getter @Setter private String address;

    /**
     * Контакт
     */
    @Getter @Setter private String contactPerson;

    /**
     * Контактный телефон
     */
    @Getter @Setter private String contactPhone;

    /**
     * Координата - Широта
     */
    @Getter @Setter private Double lat;

    /**
     * Координата - Долгота
     */
    @Getter @Setter private Double lon;

    /**
     * График работы
     */
    @Getter @Setter private String workTime;

    /**
     * Дата создания
     */
    @Getter @Setter private Date created;

    /**
     * Тип заведения
     */
    @Getter @Setter private String restaurantType;

    /**
     * Тип заведения
     */
    public enum RestaurantType {
        COFFEE,
        FASTFOOD
    }

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
