package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Workspace;
import com.desapex.spacemanager.domain.WorkspaceBooking;
import com.desapex.spacemanager.domain.WorkspaceType;
import com.desapex.spacemanager.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class WorkspaceService implements IWorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Override
    public List<Workspace> getWorkspaces(Long officeId, Long workspaceFloorId, WorkspaceType workspaceType, LocalDate date, LocalTime startTime, LocalTime endTime) {
        return workspaceRepository.findAll()
                .stream()
                .filter(workspace -> filterByOffice(workspace, officeId))
                .filter(workspace -> filterByFloor(workspace, workspaceFloorId))
                .filter(workspace -> filterByWorkspaceType(workspace, workspaceType))
                .filter(workspace -> filterByTimeRange(workspace, date, startTime, endTime))
                .collect(Collectors.toList());
    }

    private boolean filterByTimeRange(Workspace workspace, LocalDate date, LocalTime startTime, LocalTime endTime) {
        if (date == null || startTime == null || endTime == null) {
            return true;
        }
        return workspace.bookings.stream().allMatch(booking -> bookingOutsideGivenTimeRange(booking, date, startTime, endTime));
    }

    private boolean bookingOutsideGivenTimeRange(WorkspaceBooking booking, LocalDate date, LocalTime startTime, LocalTime endTime) {
        LocalDateTime start = LocalDateTime.of(date, startTime);
        LocalDateTime end = LocalDateTime.of(date, endTime);
        return (start.isBefore(booking.startTime) && end.isBefore(booking.startTime)) ||
                (start.isAfter(booking.endTime) && end.isAfter(booking.endTime));
    }

    private boolean filterByOffice(Workspace workspace, Long officeId) {
        if (officeId == null) {
            return true;
        }
        return Objects.equals(workspace.floor.office.id, officeId);
    }

    private boolean filterByFloor(Workspace workspace, Long floorId) {
        if (floorId == null) {
            return true;
        }
        return Objects.equals(workspace.floor.id, floorId);
    }

    private boolean filterByWorkspaceType(Workspace workspace, WorkspaceType workspaceType) {
        if (workspaceType == null) {
            return true;
        }
        return Objects.equals(workspace.workspaceType, workspaceType);
    }

}
