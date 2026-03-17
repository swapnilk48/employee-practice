package com.employee.practice.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.util.List;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {RoleValidationClass.class}
)
public @interface RoleValidationAnnotation {
    String message() default "Can only be a employee or admin";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
