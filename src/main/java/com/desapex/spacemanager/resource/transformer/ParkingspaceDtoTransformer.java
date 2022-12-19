package com.desapex.spacemanager.resource.transformer;

import com.desapex.spacemanager.domain.*;
import com.desapex.spacemanager.resource.dto.ParkingspaceDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ParkingspaceDtoTransformer {

    public ParkingspaceDto transform(Parkingspace parkingspace) {
        ParkingspaceDto dto = new ParkingspaceDto();
        dto.id = parkingspace.id;
        dto.name = parkingspace.name;
        dto.parkingspaceFloorId = parkingspace.floor.id;
        dto.type = parkingspace.parkingspaceType.name();
        return dto;
    }
    private String parkingSpaceStatus(Parkingspace parkingspace) {
        if (parkingspace.bookings.isEmpty()) {
            return ParkingspaceStatus.AVAILABLE.name();
        }
        return parkingspace.bookings.stream().allMatch(this::isBookingOutOfRange) ? ParkingspaceStatus.AVAILABLE.name() : ParkingspaceStatus.RESERVED.name();
    }

    private boolean isBookingOutOfRange(ParkingspaceBooking booking) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        if (!booking.date.equals(today)) {
            return true;
        }
        return booking.endTime.isBefore(now) || booking.startTime.isAfter(now);
    }

}



