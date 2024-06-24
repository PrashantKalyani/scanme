package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.resource.dto.EmployeeDto;
import com.desapex.spacemanager.resource.transformer.EmployeeDtoTransformer;
import com.desapex.spacemanager.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Collections;
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
                .map(office -> employeeDtoTransformer.transform(office))
                .collect(Collectors.toList());

        return employeeDtos;
    }

    @PostMapping(path = "resetPassword")
    public ResponseEntity<String> resetPassword(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "oldPassword") String oldPassword,
            @RequestParam(name = "newPassword") String newPassword,
            @RequestParam(name = "confirmNewPassword") String confirmNewPassword) {

        if (!newPassword.equals(confirmNewPassword)) {
            return ResponseEntity.badRequest().body("New password and confirm new password do not match.");
        }

        String result = employeeService.resetPassword(email, oldPassword, newPassword);

        if (result.equals("SUCCESS")) {
            return ResponseEntity.ok("Password reset successfully.");
        } else if (result.equals("USER_NOT_FOUND")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with this email.");
        } else if (result.equals("WRONG_PASSWORD")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect old password.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while resetting the password.");
        }
    }

    @GetMapping(path = "emailsByUsername")
    public ResponseEntity<List<String>> getEmailsByUsername(
            @RequestParam(name = "username") String username) {

        try {
            List<String> emails = employeeService.getEmailsByUsername(username);
            return ResponseEntity.ok(emails);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(e.getMessage()));
        }
    }
    @PostMapping(path = "sign")
    public ResponseEntity<String> updateSign(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "sign") String signBase64) {
        try {
            byte[] sign = Base64.getDecoder().decode(signBase64);
            employeeService.updateSign(email, sign);
            return ResponseEntity.ok("Sign updated successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(path = "sign")
    public ResponseEntity<String> getSign(
            @RequestParam(name = "email") String email) {
        try {
            byte[] sign = employeeService.getSignByEmail(email);
            if (sign == null) {
                return ResponseEntity.ok("null");
            }
            String signBase64 = Base64.getEncoder().encodeToString(sign);
            return ResponseEntity.ok(signBase64);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }
}
