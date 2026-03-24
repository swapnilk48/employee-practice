package com.employee.practice;

import com.employee.practice.Entity.Employee;
import com.employee.practice.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class PracticeApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void getRepository(){
        List<Employee> employees = employeeRepository.findByCreatedAtAfter(LocalDateTime.of(2025, 1, 1, 0, 0, 0));
        System.out.println(employees);
    }

}
