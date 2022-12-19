package com.desapex.spacemanager.resource.transformer;

import com.desapex.spacemanager.domain.WorkspaceFloor;
import com.desapex.spacemanager.resource.dto.WorkspaceFloorDto;
import org.springframework.stereotype.Component;

@Component
public class WorkspaceFloorDtoTransformer {

    public WorkspaceFloorDto transform(WorkspaceFloor workspaceFloor) {
        WorkspaceFloorDto dto = new WorkspaceFloorDto();
        dto.id = workspaceFloor.id;
        dto.name = workspaceFloor.name;
        dto.officeId = workspaceFloor.office.id;
        return dto;
    }

}
