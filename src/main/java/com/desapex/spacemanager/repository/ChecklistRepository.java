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
    @Query("SELECT c.time FROM Checklist c WHERE c.maintenanceId = :maintenanceId " +
            "AND ((c.sp IS NOT NULL AND c.fm IS NULL AND c.gm IS NULL) " +
            "OR (c.sp IS NOT NULL AND c.fm IS NOT NULL AND c.gm IS NULL)) " +
            "ORDER BY c.time DESC")
    List<LocalDateTime> findPreviousChecklists(Long maintenanceId, Pageable pageable);
}


