package com.home.takeaway.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.home.takeaway.domain.model.security.Role;
import com.home.takeaway.domain.model.security.RolePermission;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class RoleDTO {

    private String id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String creator;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> permissions;

    private Date created;

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.permissions = role.getPermissions().stream().map(RolePermission::toString).collect(Collectors.toList());
        this.created = role.getCreated();
    }

}
