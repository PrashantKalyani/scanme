package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.*;
import com.desapex.spacemanager.repository.ParkingspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ParkingspaceService implements IParkingspaceService {

    @Autowired
    private ParkingspaceRepository parkspaceRepository;

    @Override
    public List<Parkingspace> getParkingspaces(Long officeId, Long parkingspaceFloorId, ParkingspaceType parkingspaceType,  LocalDate date, LocalTime startTime, LocalTime endTime) {
        return parkspaceRepository.findAll()
                .stream()
                .filter(parkingspace -> filterByOffice(parkingspace, officeId))
                .filter(parkingspace -> filterByFloor(parkingspace, parkingspaceFloorId))
                .filter(parkingspace -> filterByParkingspaceType(parkingspace, parkingspaceType))
                .filter(workspace -> filterByTimeRange(workspace, date, startTime, endTime))
                .collect(Collectors.toList());
    }

    private boolean filterByTimeRange(Parkingspace parkingspace, LocalDate date, LocalTime startTime, LocalTime endTime) {
        if (date == null || startTime == null || endTime == null) {
            return true;
        }
        return parkingspace.bookings.stream().allMatch(booking -> bookingOutsideGivenTimeRange(booking, date, startTime, endTime));
    }

    private boolean bookingOutsideGivenTimeRange(ParkingspaceBooking booking, LocalDate date, LocalTime startTime, LocalTime endTime) {
        if (!booking.date.equals(date)) {
            return true;
        }
        return (startTime.isBefore(booking.startTime) && endTime.isBefore(booking.startTime)) ||
                (startTime.isAfter(booking.endTime) && endTime.isAfter(booking.endTime));
    }
    private boolean filterByOffice(Parkingspace parkingspace, Long officeId) {
        if (officeId == null) {
            return true;
        }
        return Objects.equals(parkingspace.floor.office.id, officeId);
    }

    private boolean filterByFloor(Parkingspace parkingspace, Long floorId) {
        if (floorId == null) {
            return true;
        }
        return Objects.equals(parkingspace.floor.id, floorId);
    }

    private boolean filterByParkingspaceType(Parkingspace parkingspace, ParkingspaceType parkingspaceType) {
        if (parkingspaceType == null) {
            return true;
        }
        return Objects.equals(parkingspace.parkingspaceType, parkingspaceType);
    }



}
