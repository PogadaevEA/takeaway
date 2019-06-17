package com.home.takeaway.domain.model.security;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Роль пользователя системы. Роль - есть набор прав.
 * Пользователь может иметь только одну роль.
 */
@Entity
@Table(name = "t_role")
public class Role {

    /**
     * Идентификатор роли
     */
    @Id
    @Column(name = "id")
    @Getter private String id;

    /**
     * Наименование роли
     */
    @Column(name = "name")
    @Getter @Setter private String name;

    /**
     * Пользователь, создавший роль
     */
    @Column(name = "creator")
    @Getter @Setter private String creator;

    /**
     * Дата создания
     */
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date created = new Date();

    /**
     * Набор прав роли
     */
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter private List<RolePermission> permissions;

}
