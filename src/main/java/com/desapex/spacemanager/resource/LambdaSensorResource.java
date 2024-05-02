package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.LambdaSensor;
import com.desapex.spacemanager.service.LambdaSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/lambda-sensors")
public class LambdaSensorResource {

    private final LambdaSensorService lambdaSensorService;

    @Autowired
    public LambdaSensorResource(LambdaSensorService lambdaSensorService) {
        this.lambdaSensorService = lambdaSensorService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createLambdaSensor(@RequestBody LambdaSensor lambdaSensor) {
        lambdaSensorService.saveLambdaSensor(lambdaSensor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Lambda Sensor log saved successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<LambdaSensor>> getAllLambdaSensors() {
        List<LambdaSensor> sensors = lambdaSensorService.getAllLambdaSensors();
        return new ResponseEntity<>(sensors, HttpStatus.OK);
    }
}

