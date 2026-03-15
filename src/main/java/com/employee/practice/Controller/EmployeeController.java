package com.employee.practice.Controller;

import com.employee.practice.DTO.EmployeeDTO;
import com.employee.practice.Entity.Employee;
import com.employee.practice.Service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok().body(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception {
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDTO employeeDTO) throws Exception {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
    }

    @PatchMapping("/updateEmployee/{employeeId}")
    public ResponseEntity<EmployeeDTO> patchEmployee(@PathVariable Long employeeId, @RequestBody Map<String, Object> updates) throws Exception {
        return ResponseEntity.ok(employeeService.updateEmployeePartially(employeeId, updates));
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long employeeId) {
        Boolean isEmpDeleted = employeeService.deleteEmployeeById(employeeId);
        if(isEmpDeleted != false){
            return ResponseEntity.ok(isEmpDeleted);
        }

        return ResponseEntity.notFound().build();
    }
}
