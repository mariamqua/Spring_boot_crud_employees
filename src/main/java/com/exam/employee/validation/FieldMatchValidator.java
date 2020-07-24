package com.exam.employee.validation;

import com.exam.employee.validation.annotations.FieldMatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldPassword;
    private String secondFieldPassword;

    public void initialize(final FieldMatch constraintAnnotation) {
        this.firstFieldPassword = constraintAnnotation.password();
        this.secondFieldPassword = constraintAnnotation.Confpassword();
    }

    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        try {
            String first = (String) getFieldValue(obj, firstFieldPassword);
            String second = (String) getFieldValue(obj, secondFieldPassword);

            if(second.equals(first)){
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private Object getFieldValue(Object object, String fieldName) throws Exception {
        Class<?> clazz = object.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);

        return field.get(object);
    }
}