package com.desapex.spacemanager.repository;

import com.desapex.spacemanager.domain.Parkingspace;
import com.desapex.spacemanager.domain.ParkingspaceBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingspaceBookingRepository extends JpaRepository<ParkingspaceBooking, Long>  {
}
