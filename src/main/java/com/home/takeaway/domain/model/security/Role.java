package com.home.takeaway.domain.model.security;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {

    @Id
    private String id;

    private String name;
    private String creator;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RolePermission> permissions;

    @Transient
    public boolean havePermission(Permission permission) {
        for (RolePermission rolePermission: this.permissions) {
            if (rolePermission.getId().getPermission().equals(permission))
                return true;
        }
        return false;
    }

    @Transient
    public boolean havePermission(String permissionName) {
        Permission permission = Permission.getInstanceByName(permissionName);
        return havePermission(permission);
    }
}