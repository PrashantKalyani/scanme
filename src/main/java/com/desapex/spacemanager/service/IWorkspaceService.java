package com.desapex.spacemanager.service;
import com.desapex.spacemanager.domain.Workspace;
import com.desapex.spacemanager.domain.WorkspaceStatus;
import com.desapex.spacemanager.domain.WorkspaceType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;


public interface IWorkspaceService {
    List<Workspace> getWorkspaces(Long officeId, Long workspaceFloorId, WorkspaceType workspaceType, LocalDate date, LocalTime startTime, LocalTime endTime);

}
