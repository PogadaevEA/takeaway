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
public class Restaurant {

    @Id
    @SequenceGenerator(name = "restaurant_seq", allocationSize = 1, sequenceName = "hibernate_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
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

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RestaurantType restaurantType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<DishRestaurantCategory> dishRestaurantCategories;
}