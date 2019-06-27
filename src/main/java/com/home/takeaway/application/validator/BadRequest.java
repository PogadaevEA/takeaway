package com.home.takeaway.application.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Тело ответа при неудачной валидации //TODO для чего вообще это надо в принципе понятно, но все же???
 */
@NoArgsConstructor
@AllArgsConstructor
public class BadRequest {

    /**
     * Причина неудачного запроса
     */
    @Getter @Setter private Reason reason;

    /**
     * Сообщение для пользователя
     */
    @Getter @Setter private String message;

    public enum Reason {
        VALIDATION,
        BADREQUEST
    }

    public static BadRequest validationFailed(String message) {
        return new BadRequest(Reason.VALIDATION, message);
    }
}
