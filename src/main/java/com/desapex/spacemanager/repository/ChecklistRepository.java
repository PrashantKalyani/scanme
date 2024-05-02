package com.desapex.spacemanager.repository;
import com.desapex.spacemanager.domain.Checklist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    Optional<Checklist> findTopByMaintenanceIdOrderByIdDesc(Long maintenanceId);
    List<Checklist> findByMaintenanceIdAndSpIsNotNullAndFmIsNullAndGmIsNullOrderByTimeDesc(Long maintenanceId, Pageable pageable);

    List<Checklist> findByMaintenanceIdAndSpIsNotNullAndFmIsNotNullAndGmIsNullOrderByTimeDesc(Long maintenanceId, Pageable pageable);
}



