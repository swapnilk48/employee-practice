package com.employee.practice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "department",
        uniqueConstraints = {
                @UniqueConstraint(name = "dept_name", columnNames = {"deptName"})
        },
        indexes = {
                @Index(name = "dept_name_idx", columnList = "deptName")
        }
)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deptName;

    private Boolean active;

    private LocalDate createdDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
