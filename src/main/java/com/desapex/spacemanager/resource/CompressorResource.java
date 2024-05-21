package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.Compressor;
import com.desapex.spacemanager.service.CompressorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compressor")
public class CompressorResource {

    @Autowired
    private CompressorService compressorService;

    @GetMapping("/list")
    public List<Compressor> getAllCompressors() {
        return compressorService.getAllCompressors();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCompressor(@RequestBody Compressor compressor) {
          compressorService.saveCompressor(compressor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Compressor log saved successfully");
    }
}
