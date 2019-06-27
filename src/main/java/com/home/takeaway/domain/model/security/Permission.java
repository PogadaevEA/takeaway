package com.home.takeaway.domain.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Набор прав для ролей пользователей системы
 */
@AllArgsConstructor
public enum Permission {

    SUPER_ADMIN("Данные всех компаний (только Администратор Ц2М)"),

    USER_READ("Пользователи: чтение"),
    USER_CREATE("Пользователи: создание"),
    USER_MODIFY("Пользователи: изменение"),
    USER_REMOVE("Пользователи: удаление"),

    ROLE_READ("Роли: чтение"),
    ROLE_CREATE("Роли: создание"),
    ROLE_MODIFY("Роли: изменение"),
    ROLE_REMOVE("Роли: удаление"),

    RESTAURANT_READ("Рестораны: чтение"),
    RESTAURANT_CREATE("Рестораны: создание"),
    RESTAURANT_MODIFY("Рестораны: изменение"),
    RESTAURANT_REMOVE("Рестораны: удаление");


    @Getter public final String value;

    public static Permission getInstanceByName(String name) {
        for (Permission permission: values()) {
            if (permission.name().equals(name)) return permission;
        }
        return null;
    }
}
