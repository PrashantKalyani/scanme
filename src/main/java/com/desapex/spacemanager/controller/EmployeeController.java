package com.desapex.spacemanager.controller;

import com.desapex.spacemanager.resource.dto.EmployeeDto;
import com.desapex.spacemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        String id = employeeService.addEmployee(employeeDto);
        return ResponseEntity.ok(id);
    }


    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String email) {
        employeeService.deleteEmployeeByEmail(email);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}