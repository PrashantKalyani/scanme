package com.desapex.spacemanager.controller;

import com.desapex.spacemanager.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private IEmployeeService userService;

    @GetMapping("space-manager/username={username}&password={password}")
    public ResponseEntity<Map<String, Object>> UserLogin(@PathVariable("username") String username1, @PathVariable("password") String password1) {
        Map<String, Object> loginResult = userService.loginValidation(username1, password1);
        if ((int) loginResult.get("userId") == -1) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(loginResult);
        }
    }
}

