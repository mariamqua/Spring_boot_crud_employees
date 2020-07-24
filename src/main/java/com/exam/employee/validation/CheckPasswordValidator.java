package com.exam.employee.validation;

import com.exam.employee.validation.annotations.PasswordValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPasswordValidator implements ConstraintValidator<PasswordValidator, String> {

    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD__PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";


    public void initialize(PasswordValidator constraintAnnotation) {
    }

    public void PasswordValidator(){
        pattern = Pattern.compile(PASSWORD__PATTERN);
    }

    public boolean isValid(String pwd, ConstraintValidatorContext constraintValidatorContext) {
        PasswordValidator();
        matcher = pattern.matcher(pwd);

        return matcher.matches();

    }
}
