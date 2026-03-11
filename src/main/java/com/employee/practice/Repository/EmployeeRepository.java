package com.employee.practice.Repository;

import com.employee.practice.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
