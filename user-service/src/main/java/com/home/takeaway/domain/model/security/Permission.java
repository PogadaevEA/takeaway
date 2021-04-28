package com.home.takeaway.domain.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
public enum Permission {

    SUPER_ADMIN("All rights"),

    USER_READ("User: read"),
    USER_CREATE("User: create"),
    USER_MODIFY("User: modify"),
    USER_REMOVE("User: remove"),

    ROLE_READ("Role: read"),
    ROLE_CREATE("Role: create"),
    ROLE_MODIFY("Role: modify"),
    ROLE_REMOVE("Role: remove"),

    RESTAURANT_READ("Restaurant: read"),
    RESTAURANT_CREATE("Restaurant: create"),
    RESTAURANT_MODIFY("Restaurant: modify"),
    RESTAURANT_REMOVE("Restaurant: remove");

    @Getter
    public final String value;

    public static Permission getInstanceByName(String name) {
        return Arrays.stream(values())
                .filter(permission -> permission.name().equals(name))
                .findFirst()
                .orElse(null);
    }
}