package com.home.takeaway.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Ресторан - заведение общепита
 */
@Entity
@Table(name = "t_restaurant")
public class Restaurant {

    /**
     * Идентификатор
     */
    @Id
    @SequenceGenerator(name = "restaurant_seq", allocationSize = 1, sequenceName = "hibernate_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    @Column(name = "id", unique = true)
    @Getter private Long id;

    /**
     * Название
     */
    @Column(name = "name")
    @Getter @Setter private String name;

    /**
     * Адресс
     */
    @Column(name = "address")
    @Getter @Setter private String address;

    /**
     * Контакт
     */
    @Column(name = "contact_person")
    @Getter @Setter private String contactPerson;

    /**
     * Контактный телефон
     */
    @Column(name = "contact_phone")
    @Getter @Setter private String contactPhone;

    /**
     * Координата - Широта
     */
    @Column(name = "lat")
    @Getter @Setter private Double lat;

    /**
     * Координата - Долгота
     */
    @Column(name = "lon")
    @Getter @Setter private Double lon;

    /**
     * График работы
     */
    @Column(name = "work_time")
    @Getter @Setter private String workTime;

    /**
     * Дата создания
     */
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date created;

    /**
     * Тип заведения
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @Getter @Setter private RestaurantType restaurantType;


    /**
     * Список всех блюд ресторана и категорий
     */
    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Getter @Setter private Set<DishRestaurantCategory> dishRestaurantCategories;

    /**
     * Тип заведения
     */
    public enum RestaurantType {
        COFFEE,
        FASTFOOD
    }

}
