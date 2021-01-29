package com.home.takeaway.domain.model.security;

import com.home.takeaway.domain.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user")
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String name;
    private String surname;
    private String middleName;
    private String phone;

    /**
     * Password's hash-sum
     */
    private String password;

    /**
     * Not encoded password - temporary field
     */
    private String passwordTemp;
    private String creator;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();
}