package com.employee.practice.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DepartmentDTO {
    private Long id;

    @NotBlank(message = "Department name cannot be blank.")
    @Size(min = 2, max = 100)
    private String name;

    private Boolean active;

    @PastOrPresent(message = "Created date cannot be in future")
    private LocalDate createdDate;
}
