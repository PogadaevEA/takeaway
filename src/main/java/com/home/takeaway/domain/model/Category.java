package com.home.takeaway.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "t_category")
@Getter
@Setter
public class Category implements Serializable {

    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<DishRestaurantCategory> dishRestaurantCategories;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}