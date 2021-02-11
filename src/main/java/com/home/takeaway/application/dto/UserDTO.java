package com.home.takeaway.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.home.takeaway.domain.model.security.User;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String id;
    private String name;
    private String surname;
    private String middleName;
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String creator;

    private RoleDTO roleDTO;
    private Date created;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.middleName = user.getMiddleName();
        this.phone = user.getPhone();
        this.creator = user.getCreator();
        this.roleDTO = new RoleDTO(user.getRole());
        this.created = user.getCreated();
    }
}
