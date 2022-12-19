package com.desapex.spacemanager.repository;

import com.desapex.spacemanager.domain.WorkspaceBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceBookingRepository extends JpaRepository<WorkspaceBooking, Long> {
}
