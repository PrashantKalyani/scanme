package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.WorkspaceType;
import com.desapex.spacemanager.resource.dto.WorkspaceDto;
import com.desapex.spacemanager.resource.transformer.WorkspaceDtoTransformer;
import com.desapex.spacemanager.service.IWorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("workspace")
public class WorkspaceResource {
    @Autowired
    private IWorkspaceService workspaceService;

    @Autowired
    private WorkspaceDtoTransformer workspaceDtoTransformer;

    @GetMapping
    public List<WorkspaceDto> getWorkspaces(
            @RequestParam(name = "officeId", required = false) Long officeId,
            @RequestParam(name = "workspaceFloorId", required = false) Long workspaceFloorId,
            @RequestParam(name = "workspaceType", required = false) WorkspaceType workspaceType,
            @RequestParam(name = "startdate", required = false) LocalDate startdate,
            @RequestParam(name = "enddate", required = false) LocalDate enddate,
            @RequestParam(name = "startTime", required = false) LocalTime startTime,
            @RequestParam(name = "endTime", required = false) LocalTime endTime
    ) {
        LocalDateTime startDateTime = LocalDateTime.of(startdate, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(enddate, endTime).minusMinutes(1);
        return workspaceService.getWorkspaces(officeId, workspaceFloorId, workspaceType, startdate, enddate, startTime, endTime)
                .stream()
                .map(workspace -> workspaceDtoTransformer.transform(workspace, startDateTime, endDateTime))
                .collect(Collectors.toList());
    }

}