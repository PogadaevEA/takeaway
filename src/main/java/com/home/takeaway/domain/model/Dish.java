package com.home.takeaway.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "dishes")
@Getter
@Setter
public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dishes_generator")
    @SequenceGenerator(name = "dishes_generator", sequenceName = "s_dishes", allocationSize = 1)
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