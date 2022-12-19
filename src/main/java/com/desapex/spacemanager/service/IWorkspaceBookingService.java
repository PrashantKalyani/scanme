package com.desapex.spacemanager.service;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IWorkspaceBookingService {

    public Long createBooking(
            Long employeeId,
            Long workspaceId,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime
    );

}
