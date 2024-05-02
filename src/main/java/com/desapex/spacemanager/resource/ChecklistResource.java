package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.Checklist;
import com.desapex.spacemanager.domain.Request;
import com.desapex.spacemanager.resource.dto.ChecklistRequestDto;
import com.desapex.spacemanager.service.ChecklistService;
import com.desapex.spacemanager.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ChecklistResource {

    private final ChecklistService checklistService;
    private final RequestService requestService;

    @Autowired
    public ChecklistResource(ChecklistService checklistService, RequestService requestService) {
        this.checklistService = checklistService;
        this.requestService = requestService;
    }

    @PostMapping("/checklist")
    public ResponseEntity<String> createChecklist(@RequestBody Checklist checklist) {
           checklistService.saveChecklist(checklist);
        return ResponseEntity.status(HttpStatus.CREATED).body("Checklist saved successfully");
    }

    @GetMapping("/checklist/latest/{maintenanceId}")
    public ResponseEntity<?> getLatestChecklistByMaintenanceId(@PathVariable Long maintenanceId) {
        return checklistService.getLatestChecklistByMaintenanceId(maintenanceId);
    }

    @PostMapping("/checklist-and-request")
    public ResponseEntity<String> createChecklistAndRequest(@RequestBody ChecklistRequestDto checklistRequestDto) {
        try {
            Checklist checklist = checklistRequestDto.getChecklist();
            Request request = checklistRequestDto.getRequest();

            if (checklist == null || request == null) {
                return ResponseEntity.badRequest().body("Checklist and Request data are required.");
            }

            checklistService.saveChecklist(checklist);

            request.setReferenceid(checklist.getId());

            requestService.saveRequest(request);

            return ResponseEntity.status(HttpStatus.CREATED).body("Checklist and Request created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create Checklist and Request: " + e.getMessage());
        }
    }

    @GetMapping("/checklist/{checklistId}")
    public ResponseEntity<?> getChecklistById(@PathVariable Long checklistId) {
        Optional<Checklist> checklistOptional = checklistService.getChecklistById(checklistId);
        if (checklistOptional.isPresent()) {
            return ResponseEntity.ok().body(checklistOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}