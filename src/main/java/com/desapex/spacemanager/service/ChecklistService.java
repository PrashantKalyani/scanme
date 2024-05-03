package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Checklist;
import com.desapex.spacemanager.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChecklistService {
    private final ChecklistRepository checklistRepository;

    @Autowired
    public ChecklistService(ChecklistRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }

    public Checklist saveChecklist(Checklist checklist) {
        checklist.setTime(Timestamp.from(Instant.now()).toLocalDateTime());
        Checklist savedChecklist = checklistRepository.save(checklist);

        if (savedChecklist.getGm() != null) {
            Checklist secondChecklist = new Checklist();
            secondChecklist.setMaintenanceId(savedChecklist.getMaintenanceId());
            secondChecklist.setTime(Timestamp.from(Instant.now()).toLocalDateTime());


            checklistRepository.save(secondChecklist);
        }

        return savedChecklist;
    }

    public ResponseEntity<?> getLatestChecklistByMaintenanceId(Long maintenanceId) {
        Optional<Checklist> latestChecklistOpt = checklistRepository.findLatestByMaintenanceId(maintenanceId);

        if (latestChecklistOpt.isPresent()) {
            Checklist latestChecklist = latestChecklistOpt.get();

            List<Timestamp> previousChecklists = checklistRepository.findPreviousChecklists(maintenanceId, 2);
//            List<LocalDateTime> previousChecklistsAsDateTime = previousChecklists.stream()
//                    .map(Timestamp::toLocalDateTime)
//                    .collect(Collectors.toList());


            Map<String, Object> response = new HashMap<>();
            response.put("latestChecklist", latestChecklist);
            response.put("previousChecklists", previousChecklists);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No checklist found for maintenance ID: " + maintenanceId, HttpStatus.NOT_FOUND);
        }
    }
    public Optional<Checklist> getChecklistById(Long id) {
        return checklistRepository.findById(id);
    }

}
