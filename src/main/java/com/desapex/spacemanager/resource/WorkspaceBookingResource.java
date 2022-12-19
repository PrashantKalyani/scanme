package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.resource.dto.CreateWorkspaceBookingDto;
import com.desapex.spacemanager.service.IWorkspaceBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                dto.date,
                dto.startTime,
                dto.endTime
        );
    }

}
