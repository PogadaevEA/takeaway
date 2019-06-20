package com.home.takeaway.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Блюдо
 */
@Entity
@Table(name = "t_dish")
public class Dish {

    /**
     * Идентификатор
     */
    @Id
    @Column(name = "id")
    @Getter private Long id;

    /**
     * Название блюда
     */
    @Column(name = "name")
    @Getter @Setter private String name;

    /**
     * Цена
     */
    @Column(name = "price")
    @Getter @Setter private Double price;

    /**
     * Ингредиенты
     */
    @Column(name = "ingredients")
    @Getter @Setter private String ingredients;

    /**
     * Вес блюда
     */
    @Column(name = "weight")
    @Getter @Setter private Double weight;

    /**
     * Время приготовления
     */
    @Column(name = "cooking_time")
    @Getter @Setter private Double cookingTime;

    /**
     * Количество калорий
     */
    @Column(name = "calories")
    @Getter @Setter private Double calories;

    /**
     * Категория блюда
     */

    @Column(name = "categories")
    @Getter @Setter private Long categories;

    /**
     * Дата добавления
     */
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date created;

    /**
     * Дата обновления
     */
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date updated;
}
