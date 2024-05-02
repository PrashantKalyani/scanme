package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.Cp4Rh;
import com.desapex.spacemanager.service.Cp4RhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cp4rh")
public class Cp4RhResource {

    @Autowired
    private Cp4RhService service;

    @PostMapping("/create")
    public ResponseEntity<String> createCp4Rh(@RequestBody Cp4Rh cp4Rh) {
        service.saveCp4Rh(cp4Rh);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cp4Rh log saved successfully");
    }

    @GetMapping("/list")
    public List<Cp4Rh> getAllCp4Rh() {
        return service.getAllCp4Rh();
    }
}
