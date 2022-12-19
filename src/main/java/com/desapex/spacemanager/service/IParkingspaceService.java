package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Parkingspace;
import com.desapex.spacemanager.domain.ParkingspaceStatus;
import com.desapex.spacemanager.domain.ParkingspaceType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IParkingspaceService {
    public List<Parkingspace> getParkingspaces(Long officeId, Long parkingspaceFloorId, ParkingspaceType parkingspaceType,  LocalDate date, LocalTime startTime, LocalTime endTime);


}
