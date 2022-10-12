package com.example.temptest.support;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author hooneats
 */
public interface UpdateSupport {

    default Object updateObject(
        final Object resourceObject,
        final Optional<?> targetOptionalObject
    ) {
        validateParameterIsNull(resourceObject, targetOptionalObject);
        final var targetObject = targetOptionalObject.get();

        final var updateFieldValueMap = getUpdateMapper(resourceObject);
        readMapAndUpdateObject(targetObject, updateFieldValueMap);
        return targetObject;
    }

    private void validateParameterIsNull(Object resourceObject, Optional<?> targetOptionalObject) {
        if (Objects.isNull(resourceObject) || targetOptionalObject.isEmpty()) {
            throw new RuntimeException("Could not update, because exist is null value");
        }
    }

    private Map<String, Optional<?>> getUpdateMapper(
        final Object resourceObject) {
        final var fields = resourceObject.getClass().getDeclaredFields();

        return Arrays.stream(fields)
            .collect(
                Collectors.toMap(getEntityFieldName(), getResourceFieldValue(resourceObject)));
    }

    private Function<Field, String> getEntityFieldName() {
        return field -> {
            final var updateColumn = field.getAnnotation(UpdateColumn.class);
            if (Objects.isNull(updateColumn)) {
                return "";
            }
            return updateColumn.name();
        };
    }

    private Function<Field, Optional<?>> getResourceFieldValue(final Object resourceObject) {
        return field -> {
            try {
                field.setAccessible(true);
                return Optional.ofNullable(field.get(resourceObject));
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Could not access field");
            }
        };
    }

    private void readMapAndUpdateObject(final Object targetObject,
        final Map<String, Optional<?>> updateFieldAndValueMap) {
        updateFieldAndValueMap.forEach(updateObjectField(targetObject));
    }

    private BiConsumer<String, Optional<?>> updateObjectField(
        final Object targetObject) {
        return (key, value) -> {
            if (key.isBlank()) {
                return;
            }
            value.ifPresent(v -> {
                try {
                    final var field = targetObject.getClass().getDeclaredField(key);
                    field.setAccessible(true);
                    field.set(targetObject, v);
                } catch (Exception e) {
                    throw new RuntimeException(
                        "Could not update, maybe problem is updateColumn name");
                }
            });
        };
    }
}
