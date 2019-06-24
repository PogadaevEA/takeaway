package com.home.takeaway.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Date;

/**
 * Категории блюд кухни
 */
@Entity
@Table(name = "t_category")
public class Category {

    /**
     * Идентификатор
     */
    @Id
    @Column(name = "id")
    @Getter private Long id;

    @Column(name = "name")
    @Getter @Setter private String name;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date created;
}
