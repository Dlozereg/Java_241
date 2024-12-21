package org.knit.lab9;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clas = obj.getClass();
        Field[] fields = clas.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                System.out.println("Поле " + field.getName() + " не должно быть null.");
            }

            else if (field.isAnnotationPresent(MaxLength.class)) {
                int MaxLength = field.getAnnotation(MaxLength.class).value();
                if (field.get(obj).toString().length() > MaxLength) {
                    System.out.println("Поле " + field.getName() + " должно быть не длинее " +
                            MaxLength);
                }
            }

            else if (field.isAnnotationPresent(Min.class)) {
                int Min = field.getAnnotation(Min.class).value();
                if (field.getInt(obj) < Min) {
                    System.out.println("Поле " + field.getName() + " должно быть больше " + Min);
                }
            }
        }
    }
}
