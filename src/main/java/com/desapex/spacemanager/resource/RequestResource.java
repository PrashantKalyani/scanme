package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.Request;
import com.desapex.spacemanager.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class RequestResource {

    private final RequestService requestService;

    @Autowired
    public RequestResource(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/requests")
    public ResponseEntity<Object> createRequest(@RequestBody Request request) {
        try {
            // Validate inputs
            if (request.getSentby() == null || request.getReceivedby() == null || request.getTaskid() == null || request.getReferenceid() == null || request.getAssetdata()==null) {
                return ResponseEntity.badRequest().body("Invalid request data. 'sentby', 'receivedby','TaskId' and 'referenceid' are required fields.");
            }

            // Set the current timestamp
            request.setDate(new Date());

            // Save the request
            requestService.saveRequest(request);

            return ResponseEntity.status(HttpStatus.CREATED).body("Request created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid request data: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create request: " + e.getMessage());
        }
    }

    @GetMapping("/requests")
    public ResponseEntity<Object> getRequestsByReceivedBy(@RequestParam String receivedBy) {
        try {
            // Validate input
            if (receivedBy == null || receivedBy.isEmpty()) {
                return ResponseEntity.badRequest().body("'receivedBy' parameter is required.");
            }

            // Retrieve requests based on 'receivedBy' field
            List<Request> requests = requestService.getRequestsByReceivedby(receivedBy);

            // Check if any requests were found
            if (requests.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(requests);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve requests: " + e.getMessage());
        }
    }
}


