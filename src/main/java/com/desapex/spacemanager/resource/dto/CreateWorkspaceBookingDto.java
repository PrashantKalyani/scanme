package com.desapex.spacemanager.resource.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CreateWorkspaceBookingDto {
    public Long employeeId;
    public Long workspaceId;
    public LocalDate startdate;
    public LocalDate enddate;
    public LocalTime startTime;
    public LocalTime endTime;
    public String userName;
}
