package com.desapex.spacemanager.resource;
import com.desapex.spacemanager.domain.Pf51;
import com.desapex.spacemanager.service.Pf51Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pf51")
public class Pf51Resource {
    private final Pf51Service pf51Service;

    @Autowired
    public Pf51Resource(Pf51Service pf51Service) {
        this.pf51Service = pf51Service;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Pf51 pf51) {
        pf51Service.save(pf51);
        return ResponseEntity.status(HttpStatus.CREATED).body("PF 51 log saved successfully");
    }

    @GetMapping("/list")
    public List<Pf51> getAll() {
        return pf51Service.getAll();
    }

}
