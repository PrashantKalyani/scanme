package com.desapex.spacemanager.repository;
import com.desapex.spacemanager.domain.Checklist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    @Query(value = "SELECT * FROM checklist c WHERE c.maintenance_id = :maintenanceId ORDER BY c.time DESC LIMIT 1", nativeQuery = true)
    Optional<Checklist> findLatestByMaintenanceId(@Param("maintenanceId") Long maintenanceId);

    @Query(value = "SELECT c.time FROM checklist c WHERE c.maintenance_id = :maintenanceId " +
            "AND ((c.sp IS NOT NULL AND c.fm IS NULL AND c.gm IS NULL) " +
            "OR (c.sp IS NOT NULL AND c.fm IS NOT NULL AND c.gm IS NULL)) " +
            "ORDER BY c.time DESC LIMIT :limit", nativeQuery = true)
    List<String> findPreviousChecklists(@Param("maintenanceId") Long maintenanceId, @Param("limit") int limit);



}



