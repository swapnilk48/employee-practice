package com.employee.practice.Controller;

import com.employee.practice.DTO.DepartmentDTO;
import com.employee.practice.DTO.EmployeeDTO;
import com.employee.practice.Entity.Department;
import com.employee.practice.Exception.ResourceNotFoundException;
import com.employee.practice.Service.DepartmentService;
import com.employee.practice.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/getDepartments")
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Optional<DepartmentDTO>> getDepartmentById(@PathVariable Long id) {
        Optional<DepartmentDTO> departmentDTO= departmentService.getEmployeeById(id);

        return departmentDTO
                .map(departmentDTO1 -> ResponseEntity.ok().body(departmentDTO))
                .orElseThrow(() -> new ResourceNotFoundException("Department not found!!"));
    }

    @PostMapping(path = "/createDepartment")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO departmentDTO1 = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(departmentDTO1, HttpStatus.CREATED);
    }

    @PutMapping(path = "/updateEmployee/{departmentID}")
    public ResponseEntity<DepartmentDTO> updateEmployee(@PathVariable Long departmentID,@RequestBody DepartmentDTO departmentDTO) {
        return ResponseEntity.ok().body(departmentService.updateDepartment(departmentID, departmentDTO));
    }

    @DeleteMapping(path = "/deleteDepartment/{departmentID}")
    public ResponseEntity<DepartmentDTO> deleteEmployee(@PathVariable Long departmentID) {
        boolean result = departmentService.deleteDepartment(departmentID);

        if (result) {
            return ResponseEntity.ok().body(new DepartmentDTO());
        }

        return ResponseEntity.notFound().build();
    }
}
