package com.home.takeaway.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "t_dish")
@Getter
@Setter
public class Dish implements Serializable {

    @Id
    @SequenceGenerator(name = "dish_seq", allocationSize = 1, sequenceName = "hibernate_sequence") // TODO вроде понятно, изучить окончательно
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dish_seq")
    private Long id;

    private String name;
    private Double price;
    private String ingredients;
    private Double weight;
    private Double cookingTime;
    private Double calories;

    @OneToMany(mappedBy = "dish", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<DishRestaurantCategory> dishRestaurantCategories;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
}