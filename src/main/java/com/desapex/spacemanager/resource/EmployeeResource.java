package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.resource.dto.EmployeeDto;
import com.desapex.spacemanager.resource.transformer.EmployeeDtoTransformer;
import com.desapex.spacemanager.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("employee")
public class EmployeeResource {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeDtoTransformer employeeDtoTransformer;

    @GetMapping(path = "Employeelist")
    public List<EmployeeDto> getEmployees(
            @RequestParam(name = "organisationId", required = false) Long organisationId,
            @RequestParam(name = "officeId", required = false) Long officeId,
            @RequestParam(name = "jobstatus", required = false) String jobstatus) {
        List<EmployeeDto> employeeDtos = employeeService.getEmployees(organisationId, officeId)
                .stream()
                .filter(employee -> jobstatus == null || employee.isStatus() == Boolean.parseBoolean(jobstatus))
                .map(office -> employeeDtoTransformer.transform(office))
                .collect(Collectors.toList());

        return employeeDtos;
    }

    @PostMapping("/{employeeId}/status")
    public ResponseEntity<String> toggleEmployeeStatus(@PathVariable Long employeeId) {
        try {
            EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
            if (employeeDto != null) {
                boolean currentStatus = employeeDto.isJobstatus();
                boolean newStatus = !currentStatus; // Toggle the current status

                employeeService.updateEmployeeStatus(employeeId, newStatus);
                String statusMessage = newStatus ? "Employee status updated to Active" : "Employee status updated to Inactive";
                return ResponseEntity.ok(statusMessage);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{employeeId}/password")
    public ResponseEntity<String> resetPassword(
            @PathVariable String employeeId,
            @RequestParam String oldPassword,
            @RequestParam String newPassword) {
        try {
//            EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);

                String username = employeeId;
                boolean passwordReset = employeeService.resetPassword(username, oldPassword, newPassword);
                if (passwordReset) {
                    return ResponseEntity.ok("Password reset successful");
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid old password");
                }
//            } else {
//                return ResponseEntity.notFound().build();
//            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
