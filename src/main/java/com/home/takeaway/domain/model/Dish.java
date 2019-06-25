package com.home.takeaway.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Блюдо
 */
@Entity
@Table(name = "t_dish")
public class Dish implements Serializable {

    /**
     * Идентификатор
     */
    @Id
    @SequenceGenerator(name = "dish_seq", allocationSize = 1, sequenceName = "hibernate_sequence") // TODO вроде понятно, изучить окончательно
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dish_seq")
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
     * Категория блюда, ресторан
     */
    @OneToMany(mappedBy = "dish", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Getter @Setter private Set<DishRestaurantCategory> dishRestaurantCategories;

    /**
     * Дата создания
     */
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date created;

    /**
     * Дата обновления
     */
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP) // TODO что за аннотация?
    @Getter @Setter private Date updated;
}
