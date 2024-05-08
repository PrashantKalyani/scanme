package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.Ups;
import com.desapex.spacemanager.service.UpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/ups")
public class UpsResource {

    @Autowired
    private UpsService upsService;

    @GetMapping("/list")
    public List<Ups> getAllUps() {
        return upsService.getAllUps();
    }

    @PostMapping("/create")
    public Ups createUps(@RequestBody Ups ups) {
        ups.setTimeDone(Timestamp.from(Instant.now()).toLocalDateTime());
        return upsService.createUps(ups);
    }
}
