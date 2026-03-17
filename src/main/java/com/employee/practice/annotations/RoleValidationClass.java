package com.employee.practice.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class RoleValidationClass implements ConstraintValidator<RoleValidationAnnotation, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles = List.of("ADMIN", "USER");
        return roles.contains(s);
    }
}
