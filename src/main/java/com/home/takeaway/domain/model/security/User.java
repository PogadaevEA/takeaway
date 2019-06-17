package com.home.takeaway.domain.model.security;

import com.home.takeaway.domain.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Пользователь системы
 */
@Entity
@Table(name = "t_user")
public class User {

    /**
     * Идентификатор пользователя и его же e-mail
     */
    @Id
    @Column(name = "id")
    @Getter private String id;

    /**
     * Имя
     */
    @Column(name = "name")
    @Getter @Setter private String name;

    /**
     * Фамилия
     */
    @Column(name = "surname")
    @Getter @Setter private String surname;

    /**
     * Отчество
     */
    @Column(name = "middle_name")
    @Getter @Setter private String middleName;

    @Column(name = "phone")
    @Getter @Setter private String phone;

    /**
     * Хеш-сумма пароля
     */
    @Column(name = "password")
    @Getter @Setter private String password;

    /**
     * TODO временное поле с исходным паролем, надо будет его удалить
     */
    @Column(name = "password_temp")
    @Getter @Setter private String passwordTemp;

    /**
     * Пользователь, создавший этого польхователя
     */
    @Column(name = "creator")
    @Getter @Setter private String creator;

    /**
     * Ресторан, к которому привязан пользователь - для сотрудника
     * NULL - для клиента
     */
    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @Getter @Setter private Restaurant restaurant;

    /**
     * Роль пользователя. Обязательно должна быть задана
     */
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @Getter @Setter private Role role;

    /**
     * Дата создания
     */
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date created = new Date();

}
