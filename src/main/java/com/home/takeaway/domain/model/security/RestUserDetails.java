package com.home.takeaway.domain.model.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class RestUserDetails implements UserDetails {

    /**
     * Имя пользователя
     */
    private final String username;

    /**
     * Пароль
     */
    private final String password;

    /**
     * Идентификатор роли
     */
    @Getter private final String roleId;

    /**
     * Коллекция разрешений
     */
    private final Collection<? extends GrantedAuthority> permissions;



    public RestUserDetails(String username, String password, String roleId, Collection<GrantedAuthority> permissions) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissions;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
