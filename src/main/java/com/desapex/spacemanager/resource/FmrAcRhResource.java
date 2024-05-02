package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.FmrAcRh;
import com.desapex.spacemanager.service.FmrAcRhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fmr-ac-rh")

public class FmrAcRhResource {

    @Autowired
    private FmrAcRhService fmrAcRhService;

    @PostMapping("/create")
    public ResponseEntity<String> createFmrAcRh(@RequestBody FmrAcRh fmrAcRh) {

        fmrAcRhService.saveFmrAcRh(fmrAcRh);
        return ResponseEntity.status(HttpStatus.CREATED).body("FMR AC Rh log saved successfully");
    }

    @GetMapping("/list")
    public List<FmrAcRh> getAllFmrAcRh() {
        return fmrAcRhService.getAllFmrAcRh();
    }

}
