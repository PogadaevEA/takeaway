package com.home.takeaway.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.home.takeaway.domain.model.security.User;
import lombok.*;

import java.util.Date;

@Data
public class UserDTO {

    private String id;
    private String name;
    private String surname;
    private String middleName;
    private String phone;
    private String password;
    private String passwordTemp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String creator;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RestaurantDTO restaurantDTO;

    private RoleDTO roleDTO;
    private Date created;

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
