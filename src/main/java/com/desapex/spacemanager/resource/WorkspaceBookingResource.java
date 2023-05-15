package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.WorkspaceBooking;
import com.desapex.spacemanager.resource.dto.CreateWorkspaceBookingDto;
import com.desapex.spacemanager.service.IWorkspaceBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workspace-booking")
public class WorkspaceBookingResource {

    @Autowired
    private IWorkspaceBookingService workspaceBookingService;

    @PostMapping
    public Long createBooking(@RequestBody CreateWorkspaceBookingDto dto) {
        return workspaceBookingService.createBooking(
                dto.employeeId,
                dto.workspaceId,
                dto.startdate,
                dto.enddate,
                dto.startTime,
                dto.endTime,
                dto.userName
        );
    }

    @GetMapping
    public List<WorkspaceBooking> getAllBookings() {
        return workspaceBookingService.getAllBookings();
    }

}
