package com.home.takeaway.domain.model.security;


import com.home.takeaway.infrastructure.AbstractCompositePK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role_permissions")
@Getter
@Setter
public class RolePermission {

    @EmbeddedId
    private PK id;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Role role;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PK extends AbstractCompositePK {

        @Column(name = "role_id")
        private String roleId;

        @NotNull
        @Enumerated(EnumType.STRING)
        private Permission permission;
    }

    @Override
    public String toString() {
        return this.id.getPermission() == null ? "" : this.id.getPermission().name();
    }
}