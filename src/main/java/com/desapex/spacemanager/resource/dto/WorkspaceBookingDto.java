package com.desapex.spacemanager.resource.dto;

import com.desapex.spacemanager.domain.WorkspaceFloor;

import java.time.LocalDateTime;

public class WorkspaceBookingDto {

    public Long id;
    public String workspace;
    public String employee;
    public String firstemployee;
    public String lastemployee;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public String department;
    public String workspaceType;
    public Long employeeId;
    public Long floorNumber;
    public LocalDateTime bookingTime;



}