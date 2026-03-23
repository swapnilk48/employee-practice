package com.employee.practice.Service;

import com.employee.practice.DTO.DepartmentDTO;
import com.employee.practice.DTO.EmployeeDTO;
import com.employee.practice.Entity.Department;
import com.employee.practice.Entity.Employee;
import com.employee.practice.Exception.ResourceNotFoundException;
import com.employee.practice.Repository.DepartmentRepository;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departmentList= departmentRepository.findAll();
        return departmentList.stream()
                .map(Department -> modelMapper.map(Department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<DepartmentDTO> getEmployeeById(Long id) {
        return departmentRepository.findById(id)
                .map(department -> modelMapper.map(department, DepartmentDTO.class));
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = modelMapper.map(departmentDTO, Department.class);
        return modelMapper.map(departmentRepository.save(department), DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found!!"));

        departmentDTO.setId(departmentId);
        modelMapper.map(departmentDTO, department);

        Department updatedDepartment = departmentRepository.save(department);
        return modelMapper.map(updatedDepartment, DepartmentDTO.class);
    }

    public boolean deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElse(null);

        if (department == null) {
            return false;
        }

        departmentRepository.delete(department);
        return true;
    }
}
