package com.home.takeaway.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.home.takeaway.domain.model.security.Role;
import com.home.takeaway.domain.model.security.RolePermission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    @Getter private String id;


    @Getter @Setter private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter private String creator;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter @Setter private List<String> permissions;

    @Getter @Setter private Date created;

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.permissions = role.getPermissions().stream().map(RolePermission::toString).collect(Collectors.toList());
        this.created = role.getCreated();
    }

}
