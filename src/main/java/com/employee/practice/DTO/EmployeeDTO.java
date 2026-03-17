package com.employee.practice.DTO;


import com.employee.practice.annotations.RoleValidationAnnotation;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "First Name not found.")
    @Size(min = 2, max = 100)
    private String firstName;

    @NotBlank(message = "Last Name not found.")
    @Size(min = 2, max = 100)
    private String lastName;

    @Min(value = 18)
    @Max(value = 65)
    private Integer age;

    @Email(message = "Please enter valid email.")
    private String email;

    @RoleValidationAnnotation
    private String role;

    @Digits(integer = 10, fraction = 4, message = "Please enter a Valid salary")
    private Double salary;

    @Past(message = "Enter a date in past")
    private LocalDate dateOfBirth;

    @PastOrPresent(message = "Enter a date in past or present")
    private LocalDate dateOfJoining;

    private Boolean active;
}
