package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.TransformerLog;
import com.desapex.spacemanager.repository.TransformerLogRepository;
import com.desapex.spacemanager.service.TransformerLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transformer")
public class TransformerLogResource {

    private final TransformerLogService transformerLogService;
    private final TransformerLogRepository transformerLogRepository;

    @Autowired
    public TransformerLogResource(TransformerLogService transformerLogService, TransformerLogRepository transformerLogRepository) {
        this.transformerLogService = transformerLogService;
        this.transformerLogRepository = transformerLogRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<String> saveTransformerLog(@RequestBody TransformerLog transformerLog) {
        transformerLogService.saveTransformerLog(transformerLog);
        return ResponseEntity.status(HttpStatus.CREATED).body("Transformer log saved successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<TransformerLog>> getAllTransformerLogs() {
        List<TransformerLog> transformerLogs = transformerLogRepository.findAll();
        return ResponseEntity.ok(transformerLogs);
    }
}
