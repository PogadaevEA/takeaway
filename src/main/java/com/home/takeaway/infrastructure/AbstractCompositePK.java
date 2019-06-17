package com.home.takeaway.infrastructure;

import java.io.Serializable;
import java.lang.reflect.Field;

public class AbstractCompositePK implements Serializable {

    @Override
    public int hashCode() {
        int result = 0;
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                result ^= field.get(this).hashCode();
            }
        } catch (IllegalAccessException ignored) {

        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !this.getClass().getName().equals(obj.getClass().getName())) return false;
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ( !field.get(this).equals(field.get(obj))) return false;
            }
        } catch (IllegalAccessException e) {
            return false;
        }
        return true;
    }
}
