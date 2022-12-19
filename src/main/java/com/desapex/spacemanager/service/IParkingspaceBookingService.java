package com.desapex.spacemanager.service;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IParkingspaceBookingService {

    public Long createBooking(
            Long employeeId,
            Long parkingspaceId,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime
    );

}
