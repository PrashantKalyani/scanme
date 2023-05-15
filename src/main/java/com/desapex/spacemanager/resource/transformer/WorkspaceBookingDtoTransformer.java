package com.desapex.spacemanager.resource.transformer;

import com.desapex.spacemanager.domain.Workspace;
import com.desapex.spacemanager.domain.WorkspaceBooking;
import com.desapex.spacemanager.resource.dto.WorkspaceBookingDto;
import com.desapex.spacemanager.resource.dto.WorkspaceDto;

import java.time.LocalDateTime;

public class WorkspaceBookingDtoTransformer {
    public WorkspaceBookingDto transform(WorkspaceBooking workspaceBooking) {
        WorkspaceBookingDto dto = new WorkspaceBookingDto();
        dto.id = workspaceBooking.id;
        dto.workspace = workspaceBooking.workspace.toString();
        dto.employee = workspaceBooking.employee.toString();
        dto.startTime = workspaceBooking.startTime;
        dto.endTime = workspaceBooking.endTime;


        return dto;
    }
}
