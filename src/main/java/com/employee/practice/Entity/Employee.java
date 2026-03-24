package com.employee.practice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "employee",
        uniqueConstraints = {
                @UniqueConstraint(name="email_constraint" ,columnNames = {"email"}),
                @UniqueConstraint(name="email_linkedin_constraint", columnNames = {"email", "LinkedInURL"})},
        indexes = {
                @Index(name = "email_idx", columnList = "email")
        }
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

    private String role;

    private Double salary;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoining;

    private String LinkedInURL;

    private Boolean active;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
