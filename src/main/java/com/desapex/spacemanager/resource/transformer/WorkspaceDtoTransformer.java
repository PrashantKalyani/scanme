package com.desapex.spacemanager.resource.transformer;

import com.desapex.spacemanager.domain.Workspace;
import com.desapex.spacemanager.domain.WorkspaceBooking;
import com.desapex.spacemanager.domain.WorkspaceStatus;
import com.desapex.spacemanager.resource.dto.WorkspaceDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class WorkspaceDtoTransformer {

    public WorkspaceDto transform(Workspace workspace) {
        WorkspaceDto dto = new WorkspaceDto();
        dto.id = workspace.id;
        dto.name = workspace.name;
        dto.workspaceFloorId = workspace.floor.id;
        dto.type = workspace.workspaceType.name();
        dto.status = workSpaceStatus(workspace);
        dto.maxOccupancy = workspace.maxOccupancy;
        return dto;
    }

    private String workSpaceStatus(Workspace workspace) {
        if (workspace.bookings.isEmpty()) {
            return WorkspaceStatus.AVAILABLE.name();
        }
        return workspace.bookings.stream().allMatch(this::isBookingOutOfRange) ? WorkspaceStatus.AVAILABLE.name() : WorkspaceStatus.RESERVED.name();
    }

    private boolean isBookingOutOfRange(WorkspaceBooking booking) {
        LocalDateTime now = LocalDateTime.now();
        return booking.endTime.isBefore(now) || booking.startTime.isAfter(now);
    }

}
