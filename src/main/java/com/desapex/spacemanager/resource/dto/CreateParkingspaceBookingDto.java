package com.desapex.spacemanager.resource.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateParkingspaceBookingDto {
    public Long employeeId;
    public Long parkingspaceId;
    public LocalDate date;
    public LocalTime startTime;
    public LocalTime endTime;
}
