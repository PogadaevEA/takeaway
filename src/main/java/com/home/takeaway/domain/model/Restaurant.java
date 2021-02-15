package com.home.takeaway.domain.model;

import com.home.takeaway.domain.model.security.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Ресторан - заведение общепита
 */
@Entity
@Table(name = "restaurants")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_restaurants")
    private Long id;

    private String name;
    private String address;
    private String contactPerson;
    private String contactPhone;
    private Double lat;
    private Double lon;
    private String workTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<DishRestaurantCategory> dishRestaurantCategories;

    public abstract RestaurantType getRestaurantType();
}