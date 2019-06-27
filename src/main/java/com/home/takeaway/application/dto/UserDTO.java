package com.home.takeaway.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.home.takeaway.domain.model.security.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Getter @Setter private String id;

    @Getter @Setter private String name;

    @Getter @Setter private String surname;

    @Getter @Setter private String middleName;

    @Getter @Setter private String phone;

    @Getter @Setter private String password;

    @Getter @Setter private String passwordTemp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter private String creator;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter private RestaurantDTO restaurantDTO;

    @Getter @Setter private RoleDTO roleDTO;

    @Getter @Setter private Date created;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.middleName = user.getMiddleName();
        this.phone = user.getPhone();
        this.password = user.getPassword();
        this.passwordTemp = user.getPasswordTemp();
        this.creator = user.getCreator();
        this.restaurantDTO = user.getRestaurant() != null ? new RestaurantDTO(user.getRestaurant()) : null;
        this.roleDTO = new RoleDTO(user.getRole());
        this.created = user.getCreated();
    }
}
