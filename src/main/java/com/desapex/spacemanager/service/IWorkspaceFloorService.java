package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.WorkspaceFloor;
import java.util.List;

public interface IWorkspaceFloorService {

    public List<WorkspaceFloor> getFloors(Long officeId);

}
