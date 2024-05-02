package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.Line7;
import com.desapex.spacemanager.service.Line7Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/line7")
public class Line7Resource {

    @Autowired
    private Line7Service line7Service;

    @PostMapping("/create")
    public ResponseEntity<String> saveLine7(@RequestBody Line7 line7) {
        line7Service.saveLine7(line7);
        return ResponseEntity.status(HttpStatus.CREATED).body("Line 7 log saved successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Line7>> getAllLine7() {
        List<Line7> line7List = line7Service.getAllLine7();
        return new ResponseEntity<>(line7List, HttpStatus.OK);
    }
}
