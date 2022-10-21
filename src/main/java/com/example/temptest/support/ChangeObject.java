package com.example.temptest.support;

import java.lang.reflect.Field;
import java.util.Arrays;

public interface ChangeObject {

    default public <T> T changeValues(T object) {
        Field[] declaredFields = this.getClass().getDeclaredFields();
        Arrays.stream(declaredFields)
            .forEach(field -> {
                try {
                    field.setAccessible(true);
                    field.set(this, field.get(object));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });
        return (T) this;
    }
}
