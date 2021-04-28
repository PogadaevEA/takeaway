package com.home.takeaway.domain.model;


import com.home.takeaway.infrastructure.AbstractCompositePK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dish_restaurant_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishRestaurantCategory {

    @EmbeddedId
    private PK id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("dishId")
    @JoinColumn(name = "dish_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Dish dish;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("restaurantId")
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Restaurant restaurant;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("categoryId")
    @JoinColumn(name = "category_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Category category;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PK extends AbstractCompositePK {

        @NotNull
        private Long dishId;

        @NotNull
        @Getter @Setter private Long restaurantId;

        @NotNull
        @Getter @Setter private String categoryId;
    }
}