package com.desapex.spacemanager.resource.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateWorkspaceBookingDto {
    public Long employeeId;
    public Long workspaceId;
    public LocalDate date;
    public LocalTime startTime;
    public LocalTime endTime;
}
