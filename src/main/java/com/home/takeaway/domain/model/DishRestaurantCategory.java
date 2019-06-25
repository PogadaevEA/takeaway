package com.home.takeaway.domain.model;


import com.home.takeaway.infrastructure.AbstractCompositePK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_dish_restaurant_category")
@NoArgsConstructor
@AllArgsConstructor
public class DishRestaurantCategory {

    @EmbeddedId
    @Getter @Setter private PK id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // TODO что за cascade???
    @MapsId("dishId")
    @JoinColumn(name = "dish_id", referencedColumnName = "id", updatable = false, insertable = false)
    @Getter @Setter private Dish dish;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("restaurantId")
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", updatable = false, insertable = false)
    @Getter @Setter private Restaurant restaurant;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("categoryId")
    @JoinColumn(name = "category_id", referencedColumnName = "id", updatable = false, insertable = false)
    @Getter @Setter private Category category;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PK extends AbstractCompositePK {

        @Column(name = "dish_id", nullable = false)
        @Getter @Setter private Long dishId;

        @Column(name = "restaurant_id", nullable = false)
        @Getter @Setter private Long restaurantId;

        @Column(name = "category_id", nullable = false)
        @Getter @Setter private String categoryId;

    }
}
