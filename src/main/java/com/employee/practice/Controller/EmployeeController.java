package com.employee.practice.Controller;

import com.employee.practice.DTO.EmployeeDTO;
import com.employee.practice.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/id/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/createEmployee")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception {
        return employeeService.addEmployee(employeeDTO);
    }
}
