package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.Line56;
import com.desapex.spacemanager.service.Line56Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/line56")
public class Line56Resource {
    private final Line56Service line56Service;

    @Autowired
    public Line56Resource(Line56Service line56Service) {
        this.line56Service = line56Service;
    }

    @PostMapping("/create")
    public ResponseEntity<String> addLine56(@RequestBody Line56 line56) {

        line56Service.saveLine56(line56);
        return ResponseEntity.status(HttpStatus.CREATED).body("Line 5 & 6 log saved successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Line56>> getAllLine56() {
        List<Line56> line56List = line56Service.getAllLine56();
        return new ResponseEntity<>(line56List, HttpStatus.OK);
    }
}
