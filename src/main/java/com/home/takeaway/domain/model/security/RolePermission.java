package com.home.takeaway.domain.model.security;


import com.home.takeaway.infrastructure.AbstractCompositePK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Связь роли и набора прав
 */
@Entity
@Table(name = "t_role_permission")
public class RolePermission {

    /**
     * Составной ключ
     */
    @EmbeddedId
    @Getter @Setter private PK id;

    /**
     * Роль
     */
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    @Getter @Setter private Role role;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PK extends AbstractCompositePK {

        @Column(name = "role_id", nullable = false)
        @Getter @Setter private String roleId;

        @Column(name = "permission", nullable = false)
        @Enumerated(EnumType.STRING)
        @Getter @Setter private Permission permission;
    }

    @Override
    public String toString() {
        return this.id.getPermission() == null ? "" : this.id.getPermission().name();
    }
}
