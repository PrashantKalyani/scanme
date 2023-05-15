package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.WorkspaceBooking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IWorkspaceBookingService {

    public Long createBooking(
            Long employeeId,
            Long workspaceId,
            LocalDate startdate,
            LocalDate enddate,
            LocalTime startTime,
            LocalTime endTime,
            String userName
    );
    List<WorkspaceBooking> getAllBookings();
}
