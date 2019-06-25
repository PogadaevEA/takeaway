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
 * Категории блюд кухни
 */
@Entity
@Table(name = "t_category")
public class Category implements Serializable {

    public static final String FASTFOOD = "FASTFOOD";
    public static final String COFFEE = "COFFEE";

    /**
     * Идентификатор
     */
    @Id
    @Column(name = "id")
    @Getter private String id;

    /**
     * Наименование категории
     */
    @Column(name = "name")
    @Getter @Setter private String name;

    /**
     * Список всех блюд в этой категории, ресторанов
     */
    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Getter @Setter private Set<DishRestaurantCategory> dishRestaurantCategories;

    /**
     * Дата создания
     */
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date created;

}
