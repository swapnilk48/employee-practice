package com.employee.practice.Service;

import com.employee.practice.DTO.EmployeeDTO;
import com.employee.practice.Entity.Employee;
import com.employee.practice.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    EmployeeService (EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();

        return employeeList.stream()
                .map(Employee -> modelMapper.map(Employee, EmployeeDTO.class))
                .collect(Collectors.toList());

    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee toSave = employeeRepository.save(employee);
        EmployeeDTO newEmployee = modelMapper.map(toSave, EmployeeDTO.class);
        return newEmployee;
    }

    public EmployeeDTO getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employee, EmployeeDTO.class);
    }
}
