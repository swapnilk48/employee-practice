package com.employee.practice.DTO;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeDTO {
    private long id;

    private String firstName;

    private String lastName;

    private String email;
}
