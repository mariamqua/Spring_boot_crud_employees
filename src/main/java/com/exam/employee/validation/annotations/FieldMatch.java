package com.exam.employee.validation.annotations;


import com.exam.employee.validation.FieldMatchValidator;

import java.lang.annotation.Target;
import javax.validation.Payload;
import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch
{
    String message() default "The fields must match";
    String password();
    String Confpassword();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}